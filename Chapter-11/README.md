# Ch. 11 - Java Applet and Graphics
## Applet
Applet program can be embedded in <applet> tag in a HTML document, downloaded from web server to client,
and executed on the web browser. The browser with higher version of JVM than applet does not require extra JVM downloading by a user.
Java applet cannot run other programs from client, or create the new process due to the security issues.
It does not make the new connection to the other hosts, other than web server.
  
Java applet is one of the Java GUI programs since it is derived from Panel class. Applet in AWT should import java.awt.Applet,
and JApplet should do so javax.swing.JApplet.
  
