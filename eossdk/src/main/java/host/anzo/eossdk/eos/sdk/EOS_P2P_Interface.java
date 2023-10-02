package host.anzo.eossdk.eos.sdk;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;
import host.anzo.eossdk.eos.exceptions.EOSException;
import host.anzo.eossdk.eos.exceptions.EOSInvalidParametersException;
import host.anzo.eossdk.eos.exceptions.EOSNotFoundException;
import host.anzo.eossdk.eos.sdk.common.EOS_NotificationId;
import host.anzo.eossdk.eos.sdk.common.EOS_ProductUserId;
import host.anzo.eossdk.eos.sdk.common.enums.EOS_EResult;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_PacketQueueInfo;
import host.anzo.eossdk.eos.sdk.p2p.EOS_P2P_SocketId;
import host.anzo.eossdk.eos.sdk.p2p.callbackresults.EOS_P2P_AddNotifyIncomingPacketQueueFullOptions;
import host.anzo.eossdk.eos.sdk.p2p.callbacks.*;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_ENATType;
import host.anzo.eossdk.eos.sdk.p2p.enums.EOS_ERelayControl;
import host.anzo.eossdk.eos.sdk.p2p.options.*;
import host.anzo.eossdk.eos.utils.CallbackUtils;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * P2P functions to help manage sending and receiving of messages to peers.
 * <p>
 * These functions will attempt to punch through NATs, but will fallback to using Epic relay servers if a direct connection cannot be established.
 *
 * @author Anton Lasevich
 * @since 8/21/2023
 */
public class EOS_P2P_Interface extends PointerType {
	public EOS_P2P_Interface(Pointer address) {
		super(address);
	}

	public EOS_P2P_Interface() {
		super();
	}

	/**
	 * Send a packet to a peer at the specified address. If there is already an open connection to this peer, it will be
	 * sent immediately. If there is no open connection, an attempt to connect to the peer will be made. An EOS_Success
	 * result only means the data was accepted to be sent, not that it has been successfully delivered to the peer.
	 *
	 * @param options Information about the data being sent, by who, to who
	 * @return {@link EOS_EResult#EOS_Success}           - If packet was queued to be sent successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input was invalid<br>
	 *         {@link EOS_EResult#EOS_LimitExceeded}     - If amount of data being sent is too large, or the outgoing packet queue was full<br>
	 *         {@link EOS_EResult#EOS_NoConnection}      - If bDisableAutoAcceptConnection was set to EOS_TRUE and the connection was not currently accepted (call EOS_P2P_AcceptConnection first, or set bDisableAutoAcceptConnection to EOS_FALSE)
	 */
	public EOS_EResult sendPacket(EOS_P2P_SendPacketOptions options) {
		return EOSLibrary.instance.EOS_P2P_SendPacket(this, options);
	}

	/**
	 * Gets the size of the packet that will be returned by ReceivePacket for a particular user, if there is any available
	 * packets to be retrieved.
	 *
	 * @param options Information about who is requesting the size of their next packet
	 * @param outPacketSizeBytes The amount of bytes required to store the data of the next packet for the requested user
	 * @return {@link EOS_EResult#EOS_Success} - If OutPacketSizeBytes was successfully set and there is data to be received<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input was invalid<br>
	 *         {@link EOS_EResult#EOS_NotFound}  - If there are no packets available for the requesting user
	 */
	public EOS_EResult getNextReceivedPacketSize(EOS_P2P_GetNextReceivedPacketSizeOptions options, IntBuffer outPacketSizeBytes) {
		return EOSLibrary.instance.EOS_P2P_GetNextReceivedPacketSize(this, options, outPacketSizeBytes);
	}

	/**
	 * Receive the next packet for the local user, and information associated with this packet, if it exists.
	 *
	 * @param options Information about who is requesting the size of their next packet, and how much data can be stored safely
	 * @param outPeerId The Remote User who sent data. Only set if there was a packet to receive.
	 * @param outSocketId The Socket ID of the data that was sent. Only set if there was a packet to receive.
	 * @param outChannel The channel the data was sent on. Only set if there was a packet to receive.
	 * @param outData Buffer to store the data being received. Must be at least EOS_P2P_GetNextReceivedPacketSize in length or data will be truncated
	 * @param outBytesWritten The amount of bytes written to OutData. Only set if there was a packet to receive.
	 * @return {@link EOS_EResult#EOS_Success} - If the packet was received successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - If input was invalid<br>
	 *         {@link EOS_EResult#EOS_NotFound} - If there are no packets available for the requesting user
	 *
	 * @see #getNextReceivedPacketSize(EOS_P2P_GetNextReceivedPacketSizeOptions, IntBuffer)
	 */
	public EOS_EResult receivePacket(EOS_P2P_ReceivePacketOptions options,
	                                  EOS_ProductUserId outPeerId,
	                                  EOS_P2P_SocketId outSocketId,
	                                  ByteBuffer outChannel,
	                                  Pointer outData,
	                                  IntBuffer outBytesWritten) {
		return EOSLibrary.instance.EOS_P2P_ReceivePacket(this, options, outPeerId, outSocketId, outChannel, outData, outBytesWritten);
	}

	/**
	 * Listen for incoming connection requests on a particular Socket ID, or optionally all Socket IDs. The bound function
	 * will only be called if the connection has not already been accepted.
	 *
	 * @param options Information about who would like notifications, and (optionally) only for a specific socket
	 * @param clientData This value is returned to the caller when ConnectionRequestHandler is invoked
	 * @param connectionRequestHandler The callback to be fired when we receive a connection request
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 *
	 * @see #removeNotifyPeerConnectionRequest(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyPeerConnectionRequest(EOS_P2P_AddNotifyPeerConnectionRequestOptions options,
	                                                          Pointer clientData,
	                                                          EOS_P2P_OnIncomingConnectionRequestCallback connectionRequestHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_P2P_AddNotifyPeerConnectionRequest(this, options, clientData, connectionRequestHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, connectionRequestHandler);
		}
		return notificationId;
	}

	/**
	 * Stop listening for connection requests on a previously bound handler.
	 *
	 * @param notificationId The previously bound notification ID
	 *
	 * @see #addNotifyPeerConnectionRequest(EOS_P2P_AddNotifyPeerConnectionRequestOptions, Pointer, EOS_P2P_OnIncomingConnectionRequestCallback)
	 */
	public void removeNotifyPeerConnectionRequest(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_P2P_RemoveNotifyPeerConnectionRequest(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Listen for when a connection is established. This is fired when we first connect to a peer, when we reconnect to a peer after a connection interruption,
	 * and when our underlying network connection type changes (for example, from a direct connection to relay, or vice versa). Network Connection Type changes
	 * will always be broadcast with a EOS_CET_Reconnection connection type, even if the connection was not interrupted.
	 *
	 * @param options Information about who would like notifications about established connections, and for which socket
	 * @param clientData This value is returned to the caller when ConnectionEstablishedHandler is invoked
	 * @param connectionEstablishedHandler The callback to be fired when a connection has been established
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 *
	 * @see #addNotifyPeerConnectionInterrupted(EOS_P2P_AddNotifyPeerConnectionInterruptedOptions, Pointer, EOS_P2P_OnPeerConnectionInterruptedCallback)
	 * @see #addNotifyPeerConnectionClosed(EOS_P2P_AddNotifyPeerConnectionClosedOptions, Pointer, EOS_P2P_OnRemoteConnectionClosedCallback)
	 * @see #removeNotifyPeerConnectionEstablished(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyPeerConnectionEstablished(EOS_P2P_AddNotifyPeerConnectionEstablishedOptions options,
	                                                              Pointer clientData,
	                                                              EOS_P2P_OnPeerConnectionEstablishedCallback connectionEstablishedHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_P2P_AddNotifyPeerConnectionEstablished(this, options, clientData, connectionEstablishedHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, connectionEstablishedHandler);
		}
		return notificationId;
	}

	/**
	 * Stop notifications for connections being established on a previously bound handler.
	 *
	 * @param notificationId The previously bound notification ID
	 *
	 * @see #addNotifyPeerConnectionEstablished(EOS_P2P_AddNotifyPeerConnectionEstablishedOptions, Pointer, EOS_P2P_OnPeerConnectionEstablishedCallback)
	 */
	public void removeNotifyPeerConnectionEstablished(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_P2P_RemoveNotifyPeerConnectionEstablished(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Listen for when a previously opened connection is interrupted. The connection will automatically attempt to reestablish, but it may not be successful.
	 * <p>
	 * If a connection reconnects, it will trigger the P2P PeerConnectionEstablished notification with the EOS_CET_Reconnection connection type.
	 * If a connection fails to reconnect, it will trigger the P2P PeerConnectionClosed notification.
	 *
	 * @param options Information about who would like notifications about interrupted connections, and for which socket
	 * @param clientData This value is returned to the caller when ConnectionInterruptedHandler is invoked
	 * @param connectionInterruptedHandler The callback to be fired when an open connection has been interrupted
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 *
	 * @see #addNotifyPeerConnectionEstablished(EOS_P2P_AddNotifyPeerConnectionEstablishedOptions, Pointer, EOS_P2P_OnPeerConnectionEstablishedCallback)
	 * @see #addNotifyPeerConnectionClosed(EOS_P2P_AddNotifyPeerConnectionClosedOptions, Pointer, EOS_P2P_OnRemoteConnectionClosedCallback)
	 * @see #removeNotifyPeerConnectionInterrupted(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyPeerConnectionInterrupted(EOS_P2P_AddNotifyPeerConnectionInterruptedOptions options,
	                                                              Pointer clientData,
	                                                              EOS_P2P_OnPeerConnectionInterruptedCallback connectionInterruptedHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_P2P_AddNotifyPeerConnectionInterrupted(this, options, clientData, connectionInterruptedHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, connectionInterruptedHandler);
		}
		return notificationId;
	}

	/**
	 * Stop notifications for connections being interrupted on a previously bound handler.
	 *
	 * @param notificationId The previously bound notification ID
	 *
	 * @see #addNotifyPeerConnectionInterrupted(EOS_P2P_AddNotifyPeerConnectionInterruptedOptions, Pointer, EOS_P2P_OnPeerConnectionInterruptedCallback)
	 */
	public void removeNotifyPeerConnectionInterrupted(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_P2P_RemoveNotifyPeerConnectionInterrupted(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Listen for when a previously opened connection is closed.
	 *
	 * @param options Information about who would like notifications about closed connections, and for which socket
	 * @param clientData This value is returned to the caller when ConnectionClosedHandler is invoked
	 * @param connectionClosedHandler The callback to be fired when an open connection has been closed
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 *
	 * @see #addNotifyPeerConnectionEstablished(EOS_P2P_AddNotifyPeerConnectionEstablishedOptions, Pointer, EOS_P2P_OnPeerConnectionEstablishedCallback)
	 * @see #addNotifyPeerConnectionInterrupted(EOS_P2P_AddNotifyPeerConnectionInterruptedOptions, Pointer, EOS_P2P_OnPeerConnectionInterruptedCallback)
	 * @see #removeNotifyPeerConnectionClosed(EOS_NotificationId)
	 */
	public EOS_NotificationId addNotifyPeerConnectionClosed(EOS_P2P_AddNotifyPeerConnectionClosedOptions options,
	                                                         Pointer clientData,
	                                                         EOS_P2P_OnRemoteConnectionClosedCallback connectionClosedHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_P2P_AddNotifyPeerConnectionClosed(this, options, clientData, connectionClosedHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, connectionClosedHandler);
		}
		return notificationId;
	}

	/**
	 * Stop notifications for connections being closed on a previously bound handler.
	 *
	 * @param notificationId The previously bound notification ID
	 *
	 * @see #addNotifyPeerConnectionClosed(EOS_P2P_AddNotifyPeerConnectionClosedOptions, Pointer, EOS_P2P_OnRemoteConnectionClosedCallback)
	 */
	public void removeNotifyPeerConnectionClosed(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_P2P_RemoveNotifyPeerConnectionClosed(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Accept or Request a connection with a specific peer on a specific Socket ID.
	 * <p>
	 * If this connection was not already locally accepted, we will securely message the peer, and trigger a PeerConnectionRequest notification notifying
	 * them of the connection request. If the PeerConnectionRequest notification is not bound for all Socket IDs or for the requested Socket ID in particular,
	 * the request will be silently ignored.
	 * <p>
	 * If the remote peer accepts the connection, a notification will be broadcast to the EOS_P2P_AddNotifyPeerConnectionEstablished when the connection is
	 * ready to send packets.
	 * <p>
	 * If multiple Socket IDs are accepted with one peer, they will share one physical socket.
	 * <p>
	 * Even if a connection is already locally accepted, EOS_EResult::EOS_Success will still be returned if the input was valid.
	 *
	 * @param options Information about who would like to accept a connection, and which connection
	 * @return {@link EOS_EResult#EOS_Success} - if the provided data is valid<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the provided data is invalid
	 */
	public EOS_EResult acceptConnection(EOS_P2P_AcceptConnectionOptions options) {
		return EOSLibrary.instance.EOS_P2P_AcceptConnection(this, options);
	}

	/**
	 * For all (or optionally one specific) Socket ID(s) with a specific peer: stop receiving packets, drop any locally queued packets, and if no other
	 * Socket ID is using the connection with the peer, close the underlying connection.
	 * <p>
	 * If your application wants to migrate an existing connection with a peer it already connected to, it is recommended to call EOS_P2P_AcceptConnection
	 * with the new Socket ID first before calling EOS_P2P_CloseConnection, to prevent the shared physical socket from being torn down prematurely.
	 *
	 * @param options Information about who would like to close a connection, and which connection.
	 * @return {@link EOS_EResult#EOS_Success} - if the provided data is valid<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the provided data is invalid
	 */
	public EOS_EResult closeConnection(EOS_P2P_CloseConnectionOptions options) {
		return EOSLibrary.instance.EOS_P2P_CloseConnection(this, options);
	}

	/**
	 * Close any open Connections for a specific Peer Connection ID.
	 *
	 * @param options Information about who would like to close connections, and by what socket ID
	 * @return {@link EOS_EResult#EOS_Success} - if the provided data is valid<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the provided data is invalid
	 */
	public EOS_EResult closeConnections(EOS_P2P_CloseConnectionsOptions options) {
		return EOSLibrary.instance.EOS_P2P_CloseConnections(this, options);
	}

	/**
	 * Query the current NAT-type of our connection.
	 *
	 * @param options Information about what version of the EOS_P2P_QueryNATType API is supported
	 * @param clientData arbitrary data that is passed back to you in the CompletionDelegate
	 * @param completionDelegate The callback to be fired when we finish querying our NAT type
	 */
	public void queryNATType(EOS_P2P_QueryNATTypeOptions options, Pointer clientData, EOS_P2P_OnQueryNATTypeCompleteCallback completionDelegate) {
		EOSLibrary.instance.EOS_P2P_QueryNATType(this, options, clientData, completionDelegate);
	}

	/**
	 * Get our last-queried NAT-type, if it has been successfully queried.
	 *
	 * @param options Information about what version of the EOS_P2P_GetNATType API is supported
	 * @return The queried NAT Type, or unknown if unknown
	 *
	 * @throws EOSNotFoundException If we do not have queried data cached
	 */
	public EOS_ENATType getNATType(EOS_P2P_GetNATTypeOptions options) throws EOSException {
		final IntByReference outNATType = new IntByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_P2P_GetNATType(this, options, outNATType);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return EOS_ENATType.fromId(outNATType.getValue());
	}

	/**
	 * Set how relay servers are to be used. This setting does not immediately apply to existing connections, but may apply to existing
	 * connections if the connection requires renegotiation.
	 *
	 * @param options Information about relay server config options
	 * @return {@link EOS_EResult#EOS_Success} - if the options were set successfully<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the options are invalid in some way
	 *
	 * @see EOS_ERelayControl
	 */
	public EOS_EResult setRelayControl(EOS_P2P_SetRelayControlOptions options) {
		return EOSLibrary.instance.EOS_P2P_SetRelayControl(this, options);
	}

	/**
	 * Get the current relay control setting.
	 *
	 * @param options Information about what version of the EOS_P2P_GetRelayControl API is supported
	 * @param outRelayControl The relay control setting currently configured
	 * @return {@link EOS_EResult#EOS_Success} - if the input was valid<br>
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the input was invalid in some way
	 */
	public EOS_EResult getRelayControl(EOS_P2P_GetRelayControlOptions options, IntBuffer outRelayControl) {
		return EOSLibrary.instance.EOS_P2P_GetRelayControl(this, options, outRelayControl);
	}

	/**
	 * Set configuration options related to network ports.
	 *
	 * @param options Information about network ports config options
	 * @return {@link EOS_EResult#EOS_Success} - if the options were set successfully
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the options are invalid in some way
	 */
	public EOS_EResult setPortRange(EOS_P2P_SetPortRangeOptions options) {
		return EOSLibrary.instance.EOS_P2P_SetPortRange(this, options);
	}

	/**
	 * Get the current chosen port and the amount of other ports to try above the chosen port if the chosen port is unavailable.
	 *
	 * @param options Information about what version of the EOS_P2P_GetPortRange API is supported
	 * @param outPort The port that will be tried first
	 * @param outNumAdditionalPortsToTry The amount of ports to try above the value in OutPort, if OutPort is unavailable
	 * @return {@link EOS_EResult#EOS_Success} - if the input options were valid
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the input was invalid in some way
	 */
	public EOS_EResult getPortRange(EOS_P2P_GetPortRangeOptions options, ShortByReference outPort, ShortByReference outNumAdditionalPortsToTry) {
		return EOSLibrary.instance.EOS_P2P_GetPortRange(this, options, outPort, outNumAdditionalPortsToTry);
	}

	/**
	 * Sets the maximum packet queue sizes that packets waiting to be sent or received can use. If the packet queue
	 * size is made smaller than the current queue size while there are packets in the queue that would push this
	 * packet size over, existing packets are kept but new packets may not be added to the full queue until enough
	 * packets are sent or received.
	 *
	 * @param options Information about packet queue size
	 * @return {@link EOS_EResult#EOS_Success} - if the input options were valid
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if the input was invalid in some way
	 */
	public EOS_EResult setPacketQueueSize(EOS_P2P_SetPacketQueueSizeOptions options) {
		return EOSLibrary.instance.EOS_P2P_SetPacketQueueSize(this, options);
	}

	/**
	 * Gets the current cached information related to the incoming and outgoing packet queues.
	 *
	 * @param options Information about what version of the EOS_P2P_GetPacketQueueInfo API is supported
	 * @return The current information of the incoming and outgoing packet queues
	 *
	 * @throws EOSInvalidParametersException if the input was invalid in some way
	 */
	public EOS_P2P_PacketQueueInfo getPacketQueueInfo(EOS_P2P_GetPacketQueueInfoOptions options) throws EOSException {
		final EOS_P2P_PacketQueueInfo.ByReference outPacketQueueInfo = new EOS_P2P_PacketQueueInfo.ByReference();
		final EOS_EResult result = EOSLibrary.instance.EOS_P2P_GetPacketQueueInfo(this, options, outPacketQueueInfo);
		if (!result.isSuccess()) {
			throw EOSException.fromResult(result);
		}
		return outPacketQueueInfo;
	}

	/**
	 * Listen for when our packet queue has become full. This event gives an opportunity to read packets to make
	 * room for new incoming packets. If this event fires and no packets are read by calling EOS_P2P_ReceivePacket
	 * or the packet queue size is not increased by EOS_P2P_SetPacketQueueSize, any packets that are received after
	 * this event are discarded until there is room again in the queue.
	 *
	 * @param options Information about what version of the EOS_P2P_AddNotifyIncomingPacketQueueFull API is supported
	 * @param clientData Arbitrary data that is passed back to you in the CompletionDelegate
	 * @param incomingPacketQueueFullHandler The callback to be fired when the incoming packet queue is full
	 * @return A valid notification ID if successfully bound, or {@link EOS_NotificationId#EOS_INVALID_NOTIFICATIONID} otherwise
	 */
	public EOS_NotificationId addNotifyIncomingPacketQueueFull(EOS_P2P_AddNotifyIncomingPacketQueueFullOptions options,
	                                                                   Pointer clientData,
	                                                                   EOS_P2P_OnIncomingPacketQueueFullCallback incomingPacketQueueFullHandler) {
		final EOS_NotificationId notificationId = EOSLibrary.instance.EOS_P2P_AddNotifyIncomingPacketQueueFull(this, options, clientData, incomingPacketQueueFullHandler);
		if (notificationId.isValid()) {
			CallbackUtils.registerCallback(notificationId, incomingPacketQueueFullHandler);
		}
		return notificationId;
	}

	/**
	 * Stop listening for full incoming packet queue events on a previously bound handler.
	 *
	 * @param notificationId The previously bound notification ID
	 */
	public void removeNotifyIncomingPacketQueueFull(EOS_NotificationId notificationId) {
		EOSLibrary.instance.EOS_P2P_RemoveNotifyIncomingPacketQueueFull(this, notificationId);
		CallbackUtils.unregisterCallback(notificationId);
	}

	/**
	 * Clear queued incoming and outgoing packets.
	 *
	 * @param options Information about which queues should be cleared
	 * @return {@link EOS_EResult#EOS_Success} - if the input options were valid (even if queues were empty and no packets where cleared)
	 *         {@link EOS_EResult#EOS_IncompatibleVersion} - if wrong API version
	 *         {@link EOS_EResult#EOS_InvalidUser} - if an invalid/remote user was used
	 *         {@link EOS_EResult#EOS_InvalidParameters} - if input was invalid in other way
	 */
	public EOS_EResult clearPacketQueue(EOS_P2P_ClearPacketQueueOptions options) {
		return EOSLibrary.instance.EOS_P2P_ClearPacketQueue(this, options);
	}
}