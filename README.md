**This project currently is not under active development**

# Majorizer: Improved Desktop Mnemonic Assistance Tool

Majorizer, previously known as 2Know2, is a desktop application which helps
people acquire proficiency in the [Major system](https://en.wikipedia.org/wiki/Mnemonic_major_system)
by suggesting mnemonics for numbers. There are a number of applications and
websites that do this, most notably the desktop application 2Know, but I set out
to write my own because I felt unnecessarily constrained by existing solutions.
The two biggest limitations I've found in existing solutions are:

1) Inability to define custom mappings of sounds to numbers. I use a modified version of the major
   system, so when I look up mnemonics with existing solutions, I have to change
   the number to get meaningful results. For example, if I wanted a mnemonic for 
   874157, I could use the phrase "favorite lock" in my version of the major system,
   but in order to find this phrase using existing software, I have to search for
   the number 884157. Needless to say, this is quite annoying.

2) Failure to use people, places, and other references as part of the mnemonic
   database. Existing solutions appear to use only the english dictionary, which
   in my opinion detracts a lot from the potential usefulness of these solutions.

I hope to solve these problems with majorizer and make it easy for everyone to
use the Major system in their daily lives to remember phone numbers, order numbers,
credit card numbers, and the like.
	
### TODO:

- If I re-wrote this in react native I could have android, iphone, and web apps
  with the same codebase.
- Figure out the implementation of PhonemeList
- Do more refactoring to use PhonemeLists in all the places they should be used
    (this was a last-minute change and many arguments/return types are still String[])
- The program searches databases of famous people / other culturally relevant things not found in 
    ordinary dictionaries
- words are ranked algorithmically according to certain criteria:
        1) commonality
        2) pictureability: is the word easy to picture in the mind? (Example: Warrior, Counter-example: Fear)
        3) user-rated usefulness (this needs to be implemented after the ranking system)
- Major System can be re-bound
- Documentation
- Unit tests
		
