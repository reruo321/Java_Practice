# Ch. 13 - Network Programming
![13TCPIP](https://user-images.githubusercontent.com/48712088/150157893-c337e38e-4b33-45fb-b810-c75e85986ad2.png)

TCP/IP(Transmission Control Protocol/Internet Protocol) is the most typical protocol on the Internet.
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

### 4. Network Access Layer
