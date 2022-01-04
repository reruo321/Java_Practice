# Character Encoding
**Character encoding** is the process of assigning numbers to graphical characters, and enables them to be stored, transmitted, and transformed using digital computers.

## ASCII
**ASCII**(American Standard Code for Information Interchange) is a character encoding standard for electronic communication.
The standard is **7-bit** codes, and it has an extended version of 8-bit. (Extended ASCII)
### Control Characters
ASCII takes the first 32 codes (decimal 0~31) and 0x7F for control characters.
They are originally not to print information, but rather to control devices.
The last ASCII code 0x7F, "delete"(DEL), is included here, although it is far from other control characters numerically.

### Printable Characters
ASCII codes 20 (32) to 7E (126) in hex are printable characters.

## UTF
UTF, Unicode Transformation Format, is one of the two mapping methods for Unicode. The last number of the name shows how many bits are used as a unit per code point.

### UTF-8
UTF-8 uses 1~4 bytes for each code point, and it maximizes compatibility with ASCII.

## Extended Unix Code
Extended Unix Code (EUC) is a multibyte character encoding system used primarily for East Asian users, such as Korean, Japanese, and simplified Chinese.
### EUC-KR
EUC-KR (Wansung) represents Korean text using two coded character sets.

## Unified Hangul Code
Unified Hangul Code (UHC, Extended Wansung, Windows-949, MS949, Code Page 949, CP949) is the Microsoft Windows code page for the Korean language, and it extends EUC-KR. It is often used as default in Korean Windows.

For example, we can use it as an VM argument for file encoding like this.

    -Dfile.encoding=MS949
