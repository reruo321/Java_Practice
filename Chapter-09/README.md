# Ch. 9 - Input and Output
Java provides a lot of stream classes to read and write data.

## Stream
In the computer system, there are data **source** (file, network, ...) and **destination**.
Anything on files can be the source, the destination, or both of them. Stream is a continuous flow of data, a FIFO, and a one-way structure.
It connects the source and destination strongly.

## Types of Stream
According to the processing data, stream is divided into **byte stream** and **character stream**.
In addition, by the usage of the stream, it is also categorized as **data sink stream** and **data processing stream**.

### 1. Byte vs Character
#### Byte Stream
I/O stream for video or image files.
Its unit is a byte, (8-bit) and classes using names with "InputStream" or "Outstream" belong to it.
#### Character Stream
I/O stream for text data, processing by 2-byte (16-bit) Unicode character unit.
The name of the classes for it with "Reader" or "Writer".

### 2. Sink vs Processing
#### Data Sink Stream
(=Node Stream) I/O stream that directly processes the data from the source like memories, pipes, and files.
#### Data Processing Stream
(=Filter Stream) I/O stream doing a special things while processing, such as buffering, filtering, stream merging, object serialization, data conversion, and conversion between bytes and characters.

## Stream Class
### Input Stream Class
Input stream class represents a stream to input data on memory. Data sink stream can be connected with data processing stream.

    FileOutputStream fout = new FileOutputStream("data.txt");   // FileOutputStream is a data sink stream.
    DataOutputStream dout = new DataOutputStream(fout);   // DataOutputStream is a data processing stream.
    
InputStream and Reader are abstract classes which are similar to each other. While the unit of InputStream is a byte, Reader takes the unit as 2 bytes. Here are some matching classes between them.

| Class Name | Corresponding Class | Description |
| :-: | :-: | :-: |
| BufferedInputStream | BufferedReader | Have a buffer function. |
| DataInputStream | | Input for primitive type data. |
| FileInputStream | FileReader | File input. |
| FilterInputStream | FilterReader | Root of filter classes. |
| InputStream | Reader | Default input stream. |

### Output Stream Class
Output stream class provides the function to output data from the memory.

OutputStream (1byte) and Writer (2bytes) are also resemble each other.

| Class Name | Corresponding Class | Description |
| :-: | :-: | :-: |
| BufferedOutputStream | BufferedWriter | Have a buffer function. |
| DataOutputStream | | Output for primitive type data. |
| FileOutputStream | FileWriter | File output. |
| PrintStream | PrintWriter | Standard output. |
| OutputStream | Writer | Default output stream. |

## Byte I/O Stream
### Byte I/O Stream
The roots of the byte I/O stream classes are InputStream/OutputStream. Since it is an abstract class, it cannot create its object but provides default methods.

### Buffered Stream
Using a buffer to temporarily store a stream of data into the memory enhances the speed. Take BufferedInputStream and BufferedOutputStream classes to utilize the function.
### Buffer
Buffer is a portion in the memory, and the stream of data from it is collected and stored in variables. If data was stored directly into the variable, while storing an example string "ABC",
the first stored character 'A' in the variable would be overwritten by the next 'B', and so on, so the string would contain only the last character 'C'. It is not good.
However, the buffer instead stores each character one by one in consecutive memory locations, so that the stream of data can be converted into a single solid value.

## Character I/O Stream
The roots of the character I/O stream classes are Reader/Writer. Because they internally process character encoding in sequence,
they are more preferable to the byte streams when inputting/outputting strings.

## File
File class defines a plenty of fields and methods to examine and edit files.

## RandomAccessFile
RandomAccessFile enables to do random access in files.

        RandomAccessFile(File file, String mode)
        RandomAccessFile(String name, String mode)
        
For the constructors, *file* is a reference of File, *name* is a name and directory of the file, and *mode* means 'r' for read-only, 'rw' for read and write.

Because of using a file pointer, RandomAccessFile can directly access to the file. The file pointer points to the location of data I/O. The initial value of RandomAccessFile pointer is 0, and it can move via seek().

        RandomAccessFile raf = new RandomAccessFile("example.txt", "r");
        raf.seek(0);
        raf.seek(pos);
        raf.getFilePointer();

### Random Access
Default order of reading or writing information to the file in computer system is sequential, and it is called "sequential acceess". On the other hand, "random access" (direct access) allows the computer system to read or write information anywhere in the data file, using indexing. 

While sequential access has advantages when accessing information in the same order all the time and faster than random access, random access gives easier data searching for the user.

## ※ Example Explanation
### Example 04
The example shows how to use reader and writer, both of which have 2 bytes as a processing unit. Even if you move the offset by 1, since they process character by character, the writer would not be covered in weird ��� things. Then, what if it was a byte stream?

For example, if a string is like this:

        Hello 방가방가
        
A character stream "writer" will print Korean characters entirely even if some bytes for English alphabets are cut. Let's change offset of the writer of Example 04.

    public class ReaderWriterTest {
        public static void main(String [] args) throws IOException {
            FileReader fr = new FileReader("09E04reader.txt");
            OutputStreamWriter w = new OutputStreamWriter(System.out);

            char [] ch = new char[100];
            int n = 0;
            while( (n = fr.read(ch, 0, 60)) != -1){   // Started to read from offset 0
                w.write(ch, 6, n);   // BUT writer started to write from offset 6.
            }
            fr.close();
            w.close();
        }
    }
    
Since all characters in "Hello " take a byte per a character, the substring takes 6 bytes. The program then will print "방가방가". How about writing from offset 7? Remarkably, both of the Korean characters '방' and '가' take **3 bytes** each in UTF-8! Thankfully however, as the character stream processes by character unit, it will skip '방' wholly, and "가방가" will be shown.

???: Character stream is a I/O stream for text data, processing by 2-byte (16-bit) Unicode character unit.

Q: Wait, didn't you say that the character streams take 2 bytes?! Why do those 3-byte characters exist well?!

A: Well, Java encodes all characters including 1-byte UTF-8 ones which also exist in ASCII ('H', 'e', 'l', 'o', ' ', ...) and 3-byte UTF-8 Korean characters with 2-byte UTF-16 BE, and stores them into the memory. It can cast the byte data to the characters with Charset class. In conclusion, every character is allocated to 16 bits in Java, and the representation of characters on the user's monitor screen depends on the user's environment which tries to encode them.

If we use byte streams instead of character ones for this example, the output will be "��가방가" for offset 7, "�가방가" for offset 8, and "가방가" for 9. It took totally three offsets to pass the bad character outputs! It may be very easy to get confused when various bytes of characters are included in the string. Now we know why it is better to process characters with the readers and writers...
