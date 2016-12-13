'''
 parse 2to12id.txt (part of speech dictionary) and cmudict (Carnegie Mellon's
 phonological dictionary) together into one dictionary file
 
 Part of David Udelson's BrickHack 2015 project
'''

import re

# according to pep8, backslashes are a necessary evil in this case
with open('/home/david/Dropbox/2of12id.txt') as dictA, \
     open('/home/david/Dropbox/cmudict-0.7b_utf8.txt') as dictB, \
     open('/home/david/Dropbox/final_dict.txt', 'w') as outDict:
        try:
            lineA = next(dictA)
            lineB = next(dictB)
            outStr = ''
            while(1):
                # "preprocessing"
                if lineA.startswith('-'):
                    lineA = next(dictA)
                    continue
                
                if re.match(r'^[A-Z]', lineB) is None:
                    lineB = next(dictB)
                    continue
                
                wordA = lineA.split(' ')[0]
                wordB = lineB.split(' ')[0].lower()
                
                print('Comparing %s and %s' % (wordA, wordB))
                
                # main decision branch
                if(wordA == wordB):
                    print('Equal!')
                    part_of_speech = lineA.split(' ')[1][0]
                    phonology = lineB.split(' ')[1:]
                    outStr = wordA + ' ' + part_of_speech + ' ' + ' '.join(phonology)
                    outDict.write(outStr)
                #    print(outStr)
                    lineA = next(dictA)
                    lineB = next(dictA)
                elif(wordA > wordB):
                    print('Greater. Getting next B.')
                    lineB = next(dictB)
                else:
                    print('Less. Getting next A.')
                    lineA = next(dictA)
                #input()
                
                
        except StopIteration:
            pass
        except Exception as e:
            print('There was an error!')
            print(e)
