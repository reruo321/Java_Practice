# Ch. 13 - Network Programming
![13TCPIP](https://user-images.githubusercontent.com/48712088/150157893-c337e38e-4b33-45fb-b810-c75e85986ad2.png)

TCP/IP(Transmission Control Protocol/Internet Protocol) is the most typical protocol on the Internet. The figure shows the structure difference between OSI(Open System Interconnection) model and TCP/IP.
## TCP/IP Structure

TCP/IP has four layers in its structure.

### 1. Application Layer
Application layer has applications that uses network such as FTP, Telnet, SMTP.
### 2. Transport Layer
This layer transports data to target system. TCP/IP enables communication via system address and port.
There are TCP and UDP(User Datagram Protocol) in the transport layer. **TCP** is connect-oriented, and it supports errorless data transmission with stream format.
It needs some headers and continuous connections among the systems to transmit data in sequence, with no duplication and errors.
Meanwhile, UDP is a connectionless protocol transmitting datagram. It is lightweight, but no guarantee of delivery, ordering, or duplicate protection.
### 3. Internet Layer
Internet layer defines packet (or datagram) and sets its route. Packet has source IP address, destination IP address, data, and some fields. The layer checks the address of packet, goes to the address in the network, and transmits it to the host.
### 4. Network Access Layer
The layer supports network hardware things like NIC or device drivers. TCP/IP follows IEEE hardware standard, and it uses Ethernet.

## TCP/IP Address
All computers in the network with TCP/IP protocol must have their addresses. Only one address per a computer is allowed. The computers with their addresses group to organize a network, and moreover these networks compose the Internet.

IP should know the destination address to transmit data. The address is called "IP address", which must be unique for a device or a computer in the network. It contains network information to express network, and host information pointing to specific computer.

### IPv4
IPv4(Internet Protocol ver. 4) has 32bits, represented in "XXX.XXX.XXX.XXX" format. It is divided in 5 classes, and Class A, B, and C among them are used generally.

### IPv6
IPv6 has 128bits, which format is "XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX". Network can be more stable with IPv6 than with IPv4, supporting user identifications and security functions.

## Socket Programming
Socket enables duplex (bidirectional) communication between programs from server and from client, via specific port.

When the client requests service via channel, the server listens it, executes the program, and returns the result to the channel.

Java provides ServerSocket class for server, and Socket for client in package java.net.
The programs create their socket object, and use InputStream and OutputStream to communicate.

![13socket](https://user-images.githubusercontent.com/48712088/150379250-b80c2b07-79a0-4919-85d3-6410c86cc83f.png)

### ServerSocket
Class ServerSocket provides a server socket to communicate with client. It waits until it gets a request via port in network, which set in advance, and it returns proper service process to input request.

Create a server socket with one of these constructors.

    ServerSocket(int port)
    ServerSocket(int port, int backlog)
    ServerSocket(int port, int backlog, InetAddress bindAddr)
    
The class provides some methods like below:

| Method | Description |
| :-: | :-: |
| Socket accept() | Accepts a connection on the server socket. |
| void close() | Closes the server socket. |
| InetAddress getInetAddress() | Gets the local address of the server socket. |
| int getLocalPort() | Gets the port number on which the socket is listening. |

### Socket
Socket provides the socket creation on client. Refer these constructors and methods for client socket.

    Socket(InetAddress address, int port)
    Socket(InetAddress address, int port, boolean stream)
    Socket(InetAddress address, int port, InetAddress localAddr, int localPort)
    Socket(String host, int port)
    Socket(String host, int port, boolean stream)
    Socket(String host, int port, IntAddress localAddr, int localPort)
    
| Method | Description |
| :-: | :-: |
| void close() | Closes the client socket. |
| InetAddress getInetAddress() | Gets the remote IP address to which the socket is connected. |
| InputStream getInputStream() | Gets the input stream for the socket. |
| InetAddress getLocalAddress() | Gets the local IP address of the socket. |
| int getLocalPort() | Gets the local port number of the socket. |
| OutputStream getOutputStream() | Gets the output stream for the socket. |
| int getPort() | Gets the remote port number to which the socket is connected. |

Both server and client should have sockets to make socket program work well. However, by using a special port on server, the program also works even if only the client has the socket. Since in this situation server socket is already installed, it does not need additional work.

## UDP Programming
