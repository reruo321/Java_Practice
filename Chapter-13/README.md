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
While TCP guarantees accuracy and reliability of data transmission, with construction of logical channels via sockets. However, when sometimes less reliable but faster communication is needed, we can choose UDP.

UDP uses datagram as a data packet. Datagrams are sent to a receiver with destination information. However, because of their independence, it does not respond to check if message has arrived correctly, set the message in the order, or provide feedback to control flow speed. Therefore, UDP message can be reached with loss, duplicate, or unordered.

UDP programming does not include a special server socket, but DatagramSocket object as a client one. Since it is connectionless, the server socket is not necessary. It just reads and writes datagrams from the client via the datagram socket.

Java offers two classes on UDP programming in java.net package: DatagramPacket for creating and controlling datagram packets, and DatagramSocket for sending and receiving them.

### DatagramPacket
DatagramPacket is to embody connectionless packet transmitting service using datagram. Message is sent from one host to another, based on its containing information. Each packet would get its own route, and arrive in random order.

Create a datagram packet using DatagramPacket constructors.

    DatagramPacket(byte[] buf, int length)
    DatagramPacket(byte[] buf, int offset, int length)
    DatagramPacket(byte[] buf, int length, InetAddress address, int port)

DatagramPacket also supports various methods like these.

| Method | Description |
| :-: | :-: |
| InetAddress getAddress() | Gets IP address of host which is the datagram sender/receiver. |
| byte [] getData() | Gets data. |
| int getLength() | Gets the size of data. |
| int getOffset() | Gets the offset of data. |
| int getPort() | Gets the port number of the remote host. |
| void setAddress(InetAddress iaddr) | Sets IP address. |
| void setData(byte [] buf, int offset, int length) | Sets data. |
| void setLength(int length) | Sets the size of the packet. |
| void setPort(int iport) | Sets the port number. |

### DatagramSocket