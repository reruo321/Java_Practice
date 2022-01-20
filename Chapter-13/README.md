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
