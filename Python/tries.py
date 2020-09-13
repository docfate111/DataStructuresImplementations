from __future__ import annotations
from typing import *

# def printTrie(t: Trie) -> None:
#     for key, value in t.alph.items():
#         if(len(value)>0):
#             print(key)
#         for i in value:
#             printTrie(i)
    
class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.alph = {}                                                                   
        for i in 'abcdefghijklmnopqrstuvwxyz': 
             self.alph[i] = [] 

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        ptr = self.alph
        i = 0
        while(i < len(word)):
            ptr[word[i]].append(Trie())
            ptr = ptr[word[i]][-1].alph
            i += 1

    def startsWith(self, prefix: str) -> bool:
        if(len(prefix)==0):
             return True
        if(len(self.alph[prefix[0]])==0):
            return True
             # find all paths that match the next letter
        ans = False
        for branch in self.alph[prefix[0]]:
            ans = ans or branch.startsWith(prefix[1:])
        return ans
    
    def search(self, word: str) -> bool:
        if(len(word)==0):
            count = 0
            for val in self.alph.values():
                if(len(val)==0):
                    count += 1
            return count==26
        if(len(self.alph[word[0]])==0):
            return False
             # find all paths that match the next letter
        ans = False
        for branch in self.alph[word[0]]:
            ans = ans or branch.search(word[1:])
        return ans
    

    


    # def __str__(self) -> str:
    #     printTrie(self.alph)
    #     return ''

if __name__=='__main__':
    trie = Trie()
    trie.insert("apple")
    assert(trie.search("apple"))
    assert(not trie.search("app"))
    assert(trie.startsWith("app"))
    trie.insert("app");   
    assert(trie.search("app"))