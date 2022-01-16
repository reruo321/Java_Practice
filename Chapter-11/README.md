# Ch. 11 - Java Applet and Graphics
## Applet
**※ Warning! Applet was deprecated in 2017. Let's just glance at the applet, and learn Spring instead.**

Applet program can be embedded in \<applet\> tag in a HTML document, downloaded from web server to client,
and executed on the web browser. The browser with higher version of JVM than applet does not require extra JVM downloading by a user.
Java applet cannot run other programs from client, or create a new process due to the security issues.
It does not make a new connection to the other hosts, other than web server.
  
Java applet is one of the Java GUI programs since it is derived from Panel class.

### Syntax
First, define a new class whose parent is either Applet or JApplet. Applet in AWT should import java.awt.Applet, and JApplet should import javax.swing.JApplet.

    public class <Applet-Name> extends JApplet {...}
  
To run the applet program, write a HTML document and include your class to it. The below is the structure of basic HTML document have an applet.

    <HTML>
    <HEAD><TITLE>_applet_program_title_</TITLE></HEAD>
    <BODY>
    <APPLET code=_your_applet_class_name_ width=_width_ height=_height_>
    </APPLET>
    </BODY>
    </HTML>
    
Apply it like this:

    <HTML>
    <HEAD><TITLE>Hello Applet!~</TITLE></HEAD>
    <BODY>
    <APPLET code=HelloApplet.class width=300 height=200>
    </APPLET>
    </BODY>
    </HTML>
    
You must declare code, width, and height, and there are some more optional attributes for \<APPLET\> tag. Use \<PARAM\> to give some parameters to your applet.

    <APPLET CODE = _your_applet_class_name_
    WIDTH = _width_
    HEIGHT = _height_
    [ALIGN = _alignment_] <!-- Warning: Deprecated -->
    [ALT = _alternate_text_for_not_applet_supporting_browser_]
    [ARCHIVE = _jar_file_path_url_]
    [CODEBASE = _applet_base_url_]
    [HSPACE = _horizontal_spacing_] <!-- Warning: Deprecated -->
    [NAME = _applet_name_]
    [OBJECT = _serialized_applet_class_name_]
    [TITLE = _mouse_tooltip_information_]
    [VSPACE = _vertical_spacing_]> <!-- Warning: Deprecated -->
    
    [<PARAM NAME = _parameter_name_ VALUE = _parameter_value_>]
    ...
    </APPLET>
    
If you use CMD to execute the applet, use *appletviewer* command, not *java*. Run the command for a html file from myJava folder.

    C:\myJava> appletviewer HTML_DOCUMENT_NAME
    
