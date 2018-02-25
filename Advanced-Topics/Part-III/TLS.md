# TLS

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Advanced-Topics/Part-III/TLS.md

What threats does TLS protect against?

TLS allows two parties to communicate with privacy and data integrity. The messages they send are private, so they cannot be read by another party during transmission. Having data integrity means that the messages cannot be modified by another party during transmission. In additional a trusted Certificate Authority can be used so the parties that they are not communicating with an impostor and this prevents a Man-in-the Middle attack.

How does TLS protect against threats?

Modern web browsers use TLS to communicate with servers and when doing so one can inspect the technical details of the connection. This is summarised as a string similar to this: "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384_256 bit keys,TLS 1.2"
I will relate this string to how the different parts of TLS work.

First the client will begin the TLS handshake by initiating a connection to the server and sending a list of the cryptographic algorithms it supports.
For example a web browser can initiate a connection with a server to send and receive HTTP. To inform the server that the connection should use HTTP over TLS rather than plain HTTP the client can use the well-known port number 443.

The client and server will establish a shared secret using a key exchange protocol. An example of this is Diffie–Hellman key exchange which allows the client and server to create a shared secret without ever transmitting it between them. Thus they can do this even over an insecure channel. The server will also respond with the cryptographic algorithms it has selected from the list provided by the client.
In the technical details string above this corresponds to "ECDHE" which stands for Elliptic-curve Diffie–Hellman Exchange.

The server will also send it's Certificate. The client will now contact a Certificate Authority to verify that this Certificate matches the server. The Certificate contains the public key of the server which is used to request a digital signature from the server and so ensure that it is not an impostor. In public key cryptography, a different key is used to encrypt the data than that which is used to decrypt it. The encryption key is made public so anyone can encrypt data, but only the holder of the private key can decrypt it. It can also be used to produce a digital signature of a message which can then be verified by anyone by using the public key. This proves that this message was signed by the holder of the private key.
In the technical detail string above this corresponds to "RSA" which means that the asymmetric encryption algorithm used for this is RSA.

The handshake is now complete and the transmission of messages can begin.

The messages are encrypted using symmetric encryption and the key used for this is the shared secret, which was established during the key exchange part of the handshake.
In the technical detail string above this corresponds to "AES_256_GCM" which means that the symmetric encryption algorithm used is AES.

Along with each message a message authentication code (MAC) is sent, which is the hash of the message plus the shared secret. The other party can rerun the hash on the message received plus the shared secret and verify that they are equal. This ensures that the message has not been tampered with during transmission.
In the technical detail string above this corresponds to "SHA384" which means that the SHA384 hash function was used.

---

References

Wikipedia https://en.wikipedia.org/wiki/Transport_Layer_Security
