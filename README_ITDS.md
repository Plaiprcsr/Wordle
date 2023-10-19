
<h3>1.ชื่อของ test case: testPrintInstructions</h3>

**จุดประสงค์ของ test case นี้เพื่อทดสอบคำนำและเนื้อหาคำอธิบายการเล่นเกมของระบบก่อนทำงานจริงว่าตรงกับที่จัดเตรียมไว้หรือไม่**

**Interface-based Characteristics**
1. Identify testable functions: `testPrintInstructions()`
2. Identify parameter, return types, return values, and exceptional behavior
    - Parameter: `printedMessage`
    - Return type: `String`
    - Return Value: `instruction` ที่ได้ทำการกำหนดไว้ในขั้นตอนการเขียนอธิบายการเล่นเกม
3. Model input domain
    - C1 = `printedMessage` is empty

**Partition Characteristics**

| Characteristics              | B1   | B2    |
|------------------------------|------|-------|
| C1 = printedMessage is empty | True | False |

**Identify Values**

| Characteristics              | B1 | B2     |
|------------------------------|----|--------|
| C1 = printedMessage is empty | "" | "Test" |

**Derive Test**

| Test | printedMessage | Expected |
|------|----------------|----------|
| T1   | "Testing"      |    ""      |
| T2   | ""             |    ""      |

**Functionality-based Characteristics**
1. Identify testable functions: `testPrintInstructions()`
2. Identify parameter, return types, return values, and exceptional behavior
    - Parameter: `printedMessage`
    - Return type: `String`
    - Return Value: `instruction` ที่ได้ทำการกำหนดไว้ในขั้นตอนการเขียนอธิบายการเล่นเกม
3. Model input domain
    - C1 = Type of data
    - C2 = `printedMessage` contains: "The game has chosen a 5-letter word for you to guess.
      You have 6 tries. In each guess, the game will confirm which letters the chosen word and the guessed word have in common: <br>
Letters highlighted in green are in the correct place.<br>
Letters highlighted in yellow appear in the chosen word but in a different spot. <br>
Letters highlighted in grey do not appear in the chosen word.
  "

| Characteristics                                  | B1    | B2      | B3    |
|--------------------------------------------------|-------|---------|-------|
| C1 = Type of data                                | Valid | Invalid | Empty |
| C2 = printedMessage contains the desired message | True  | False   | -     |
   
  
**Combine Partition test**

 - Number of test = 3*3 = 9


**Combine partitions to define test requirements**
- Assumption: Base Choice



**ใช้ Partitioning เพื่อสร้าง test requirement (Base Choice)**

| Characteristics | B1  | B2  | B3  |
|-----------------|-----|-----|-----|
| C1              | A   | B   | C   |
| C2              | x   | y   | z   |
| C3              | 1   | 2   | -   |

- Test requirements -- number of tests (upper bound) <br>
- Base: A,a,1 <br>
  Test: 1+(3-1)+(3-1)+(2-1) = 6 <br>
  (A,a,1) , (A,a,2) , (B,a,1) ,(C,a,1) ,(A,b,1) ,(A,c,1)



<h3>2. ชื่อของ test case: testObtainValidUserWord</h3> 
**จุดประสงค์ของ test case: ตรวจสอบว่า method testObtainValidUserWord สามารถตรวจสอบ input ของ user ได้ว่ามีความยาว 5 ตัวอักษร และอยู่ใน wordList**

**Interface-Based Characteristics:**
File: English.java, Spanish.java

1. Identify testable functions:
- `testObtainValidUserWord()`

2. Identify parameters, return types, return values, and exceptional behavior:
- Parameters: `wordlist` (List<String>), `index` (int)
- Return type: `String`
- Return value: String ที่ user ได้ input

3. Model the input domain:
- Develop characteristics
    - C1 = Wordlist is empty
    - C2 = Input letter is a string


**Partition Characteristics**

| Characteristics            | B1   | B2    |
|----------------------------|------|-------|
| C1: Wordlist is Empty      | True | False | 
| C2: Input Letter is String | True | False |


**Identify Values**

| Characteristics            | B1     | B2                                              |
|----------------------------|--------|-------------------------------------------------|
| C1: Wordlist is Empty      | []     | ["apple", "banana", "cherry", "lemon", "grape"] | 
| C2: Input Letter is String | "kiwi" | 555                                             |



**Combine partitions to define test requirements**

- Assumption: choose Base Choice Coverage

**ใช้ Partitioning เพื่อสร้าง test requirement (Base Choice)**

| Characteristics | B1  | B2  |
|-----------------|-----|-----|
| C1              | A   | B   |
| C2              | x   | y   | 

- Base Choice: (A,x) <br>
  Test: 1+(2-1)+(2-1) = 3 <br>
  (A,y) , (B,x)

**Derive Test Values**

| Test             | Wordlist                                      | Wordinput | Expected                                                                            |
|------------------|-----------------------------------------------|-----------|-------------------------------------------------------------------------------------|
| T1:  (“”, True)  | []                                            | "hello"   | "The word hello is not in the word list.<br/> Please, submit a new 5-letter word. " |
| T2: (“”, False)  | []                                            | 555       | "The word hello is not in the word list.<br/> Please, submit a new 5-letter word. " |
| T3: (False,True) | ["apple", "water", "ready", "lemon", "grape"] | "lemon"    | "lemon"                                                                              |


**Functionality-Based Characteristics**

1. Identify testable functions:
- `testObtainValidUserWord()`

2. Identify parameters, return types, return values, and exceptional behavior:
- Parameters: `wordlist` (List<String>), `index` (int)
- Return type: `String`
- Return value: String ที่ user ได้ input

**Exceptional behavior:**
- If the user input does not have a length of 5 characters, it displays a message and asks for a new 5-letter word.
- If the user input is not found in the wordList, it displays a message and asks for a new 5-letter word.

3. Model the input domain:
- Develop characteristics
    - C1 = Letter length
    - C2 = Word is in Wordlist

**Partition Characteristics**

| Characteristics         | B1   | B2         | B3                             | B4             |
|-------------------------|------|------------|--------------------------------|----------------|
| C1: Letter Length       | 0    | Equal to 5 | Less than 5 but greater than 0 | Greater than 5 |
| C2: Word is in Wordlist | True | False      | -                              | -              |

**Identify (possible) values** <br>

| Characteristics         | B1   | B2      | B3    | B4          |
|-------------------------|------|---------|-------|-------------|
| C1: Letter Length       | ""    | "Berry" | "Cup" | "Pineapple" |
| C2: Word is in Wordlist | ["apple", "water", "ready", "lemon", "grape"], “lemon” | ["apple", "water", "ready", "lemon", "grape"], “Berry”   | -     | -           |

**Combine partitions to define test requirements**

- Assumption: choose Base Choice Coverage

**ใช้ Partitioning เพื่อสร้าง test requirement (Base Choice)**

| Characteristics | B1  | B2  | B3  | B4  |
|-----------------|-----|-----|-----|-----|
| C1              | A   | B   | C   | D   |
| C2              | x   | y   | -   | -   |

- Base Choice: (A,x) <br>
  Test: 1+(4-1)+(2-1) = 3 <br>
  (A,y) , (B,x) , (C,x) , (D,x)

**Derive Test Values**

| Test           | WordList                           | Word input | Expected                                                    |
|--------------- |----------------------------------- |------------ |------------------------------------------------------------ |
| T1 ("", True)  | ["apple", "water", "ready", "lemon", "grape"] | "" | "The word does not have 5 letters. Please, submit a new 5-letter word." |
| T2 ("", False) | ["apple", "water", "ready", "lemon", "grape"] | "" | "The word does not have 5 letters. Please, submit a new 5-letter word." |
| T3 (Equal to 5, True) | ["apple", "water", "ready", "lemon", "grape"] | "lemon" | "CONGRATULATIONS! YOU WON! :)" |
| T4 (less than 5 but greater than 0, True) | ["apple", "water", "ready", "lemon", "cup"] | "Cup" | "The word Cup does not have 5 letters. Please, submit a new 5-letter word." |
| T5 (greater than 5, True) | ["apple", "water", "pineapple", "lemon", "grape"] | "Pineapple" | "The word does not have 5 letters. Please, submit a new 5-letter word." |



<h3>3. ชื่อของ test case: testReplaceChar</h3>
**จุดประสงค์ของ test case: ตรวจสอบว่า method testReplaceChar สามารถตรวจสอบ การแทนที่ character ใน string ที่กำหนดใน specific index ได้อย่างถูกต้อง**

**Interface-Based Characteristics:**
File: English.java, Spanish.java

1. Identify testable functions:
- `testReplaceChar()`

2. Identify parameters, return types, return values, and exceptional behavior:
- Parameters: `originalStr` (String), `ch` (char), `index` (int)
- Return type: `String`
- Return value: string ที่ถูกแก้ไข โดยแทนที่ character ในตำแหน่ง specified index

3. Model the input domain:
- Develop characteristics
    - `str`: Any string (รวมทั้ง empty string)
    - `ch`: Any character
    - `index`: Any integer (สามารถเป็นได้ทั้ง +/-/0)

**Partition Characteristics**

| Characteristic | B1   | B2   |
|----------------|------|------|
| C1: originalStr is empty | True | False |
| C2: Valid index | True | False |
| C3: Char is empty | True | False |

**Identify Values**

| Characteristic            | B1        | B2     |
|---------------------------|-----------|--------|
| C1: originalStr is empty | ""        | "apple" |
| C2: Valid index           | True      | False  |
| C3: Char is empty        | ''        | 'a'    |

**Derive Test**

| Test | originalStr | index | Char | Expected  |
|------|-------------|-------|------|-----------|
| T1   | ''          | 1     | ''   | Error input |
| T2   | ''          | 2     | 'a'  | Error input |
| T3   | ''          | -1    | 'b'  | Error input |
| T4   | 'apple'     | -2    | 'c'  | Error input |
| T5   | 'apple'     | -3    | ''   | Error input |
| T6   | 'apple'     | 3     | ''   | Error input |
| T7   | ''          | -4    | ''   | Error input |
| T8   | 'apple'     | 4     | 'd'  | 'appde'   |

**Functionality-Based Characteristics**

1. **Identify testable functions:**
    - `testReplaceChar()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:**
        - `originalStr` (String)
        - `ch` (char)
        - `index` (int)
    - **Return type:** String
    - **Return value:** A string that has been modified by replacing the character at the specified index.

3. **Model the input domain:**

    - **C1: originalStr data type**
        
    - **ch:** Any character
        
    - **index:** Any integer (สามารถเป็นได้ทั้ง +/-/0)


| Characteristic                           | B1   | B2   | B3   |
|------------------------------------------|------|------|------|
| C1: originalStr in list                 | True | False|      |
| C2: Char is a-z                         | True | False|      |
| C3: Valid index or not                  | True | False|      |

**Combine Partitions Test**
 - Number of tests: 3*3 = 9

**Combine Partitions to Define Test Requirements**
 - Assumption: Multiple Base Choice

| Characteristic | B1  | B2  | B3  |
|--------------- |-----|-----|-----|
| C1            | A   | B   |     |
| C2            | x   | y   |     |
| C3            | 1   | 2   |     |

**Test Requirements -- number of tests (upper bound)**
 - Base: A,x,1 / B,x,1
   Tests: (A,x,1) , (A,y,1) , (A,x,2) , (B,x,1) , (B,y,1) , (B,x,2) = 6

**Derive Test**

| Test | originalStr | Char | index | Expected                                          |
|------|-------------|------|-------|---------------------------------------------------|
| T1   | 'water'     | 'a'  | 0     | "aater"                                           |
| T2   | 'apple'     | '-'  | 2     | catches the exception and prints an error message |
| T3   | 'ready'     | 'b'  | -1    | "readb"                                           |
| T4   | 'Cuple'     | 'c'  | 3     | "Cupce"                                           |
| T5   | 'house'     | '>'  | 4     | catches the exception and prints an error message       |
| T6   | 'Turbo'     | 'd'  | 6     |  catches the exception and prints an error message      |



<h3>4. ชื่อของ test case: testPrintLosingMessage</h3>
<b>จุดประสงค์ของ test case: เพื่อยืนยันว่า method testPrintLosingMessage สามารถตรวจสอบ `printLosingMessage()` method ว่าสามารถใช้งานได้และ มีการแสดงข้อความว่าผู้เล่นได้แพ้แล้ว พร้อมทั้งแสดง คำที่ถูกต้อง และ definition link เพื่อให้มั่นใจว่ามี game's feedback system functions ที่ถูกต้อง</b>

**Interface-Based Characteristics:**


1. Identify testable functions:
    - `testPrintLosingMessage()`

2. Identify parameters, return types, return values, and exceptional behavior:
    - Parameters: `chosenWord` (String), `youLostMessage` (String)
    - Return type: String
    - Return value: The printed message should contain "YOU LOST :(" and "The word's definition: [https://www.merriam-webster.com/dictionary/chosenWord](https://www.merriam-webster.com/dictionary/chosenWord)."

**Exceptional Behavior:**
- We do not expect any exceptional behavior; we expect the method to print the message as intended.

**Model the input domain:**
- Develop characteristics
    - `C1`: `chosenWord` is an empty string
    - `C2`: `youLostMessage` is empty

**Partition Characteristics**

| Characteristic                 | B1   | B2   |
|--------------------------------|------|------|
| C1: chosenWord is empty string | True | False |
| C2: youLostMessage is empty    | True | False |


**Identify Values**

| Characteristic                 | B1     | B2         |
|------------------------------|--------|-----------|
| C1: chosenWord is empty string | ""    | "apple"   |
| C2: youLostMessage is empty   | ""    | "YOU LOST :(" |


**Combine partitions to define test requirements**
- Assumption: choose All Combinations Coverage

**Partitioning เพื่อสร้าง test requirement (ACoC)**

| Characteristics | B1 | B2 |
|-----------------|----|----|
| C1              | A  | B  |
| C2              | x  | y  |

**Test Requirements -- number of tests = 2*2 = 4** <br>
(A,x) (A,y) (B,x) (B,y)

**Derive Test**

| Test | chosenWord | youLostMessage | Expected |
|------|------------|-----------------|----------|
| T1   | (True, True) | "" | The printed message should contain an empty string. |
| T2   | (True, False) | "" | The printed message should contain "Game Over" and "The word's definition: https://www.merriam-webster.com/dictionary/." |
| T3   | (False, True) | "rabid" | The printed message should contain an empty string. |
| T4   | (False, False) | "apple" | The printed message should contain "YOU LOST :(" and "The word's definition: https://www.merriam-webster.com/dictionary/apple." |


**Functionality-Based Characteristics**

1. **Identify testable functions:**
    - `testPrintLosingMessage()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:**
        - `chosenWord` (String)
        - `youLostMessage` (String)
    - **Return type:** String
    - **Return value:** String แสดง ข้อความที่แพ้ คำที่ถูกต้อง `chosenWord` และ definition link
    - **Exceptional behavior:** -

3. **Model the input domain:**

    - **Develop characteristics**
        - `C1`: Print `youLostMessage` is valid
        - `C2`: Print `chosenWord` is valid
        - `C3`: Print both `chosenWord` and `youLostMessage`

**Partition Characteristics**

| Characteristic                          | B1   | B2   | B3               |
|-----------------------------------------|------|------|------------------|
| C1: Print youLostMessage is valid       | True | False|                  |
| C2: Print chosenWord is valid           | True | False|                  |
| C3: Print both chosenWord and youLostMessage | Empty | Valid | Not Valid |


**Identify Values**

| Characteristic                          | B1    | B2        | B3        |
|----------------------------------------|-------|-----------|-----------|
| C1: Print youLostMessage is valid      | True  | False     |           |
| C2: Print chosenWord is valid          | True  | False     |           |
| C3: Print both chosenWord and youLostMessage | "" , "" | "apple" , "YOU LOST :)" | null , "Game Over" |


**Combine partitions to define test requirements**
- Assumption: choose Each Choice Coverage

**Partitioning เพื่อสร้าง Test Requirement (ECC)**

| Characteristics | B1 | B2 | B3 |
|-----------------|----|----|----|
| C1              | A  | B  |    |
| C2              | x  | y  |    |
| C3              | 1  | 2  | 3  |

**Test Requirements -- number of tests = 3** <br>
(A, x, 1) (B, y, 2) (B, y, 3)

**Derive Test**

| Test | chosenWord | youLostMessage | Expected |
|------|------------|-----------------|----------|
| T1   | (True, True) | "" | No message is printed. |
| T2   | (False, False) | "apple" | Message contains "YOU LOST :)" and a definition link. |
| T3   | (False, False) | null | No message is printed. |



<h3>5. ชื่อของ test case: testGetRandomWord</h3>

**จุดประสงค์ของ test case:** เพื่อตรวจสอบว่าคำศัพท์ที่ได้มาจาก `getRandomWord()` อยู่ใน `wordList` หรือไม่ ถ้าคำศัพท์ที่ได้มาอยู่ใน `wordList` ก็จะแสดงผล test ผ่าน (pass) ถ้าไม่อยู่ใน `wordList` ก็จะแสดงผล test ไม่ผ่าน (fail).

**Interface-Based Characteristics:**

1. **Identify testable functions:**
    - `testGetRandomWord()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:** `wordList`
    - **Return type:** String
    - **Return value:** A word randomly selected from `wordList` and returned as a string.
    - **Exceptional behavior:** -

3. **Model input domain:**

    - **Develop characteristics**
        - `C1`: `wordList` is empty

**Partition Characteristics**

| Characteristic               | B1    | B2    |
|-----------------------------|-------|-------|
| C1 = wordList is empty      | True  | False |

**Identify Values**

| Characteristic               | B1  | B2                          |
|-----------------------------|-----|-----------------------------|
| C1 = wordList is empty      | []  | ["apple", "money", "cider"] |

**Derive Test**

| Test | wordList           | Expected result                                                                |
|------|--------------------|--------------------------------------------------------------------------------|
| T1   | []                 | return null                                                                    |
| T2   | ["apple", "cider"] | randomly select and return a word from the wordList (e.g., "apple" or "cider") |

**Functionality-Based Characteristics**

1. **Identify testable functions:**
    - `testGetRandomWord()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:** `wordList`
    - **Return type:** String
    - **Return value:** A word randomly selected from `wordList` and returned as a string.
    - **Exceptional behavior:** -

3. **Model input domain:**

    - **Develop characteristics**
        - `C1`: `wordList` is empty
        - `C2`: Number of words in `wordList`
        - `C3`: `wordList` has duplicate words

**Partitioning Characteristics**

| Characteristic                  | B1    | B2    | B3    |
|--------------------------------|-------|-------|-------|
| C1 = wordList is empty         | True  | False |       |
| C2 = number of words in wordList | 0   | 1     | >1   |
| C3 = wordList has duplicate words | True  | False |       |

**Identify Values**

| Characteristic                     | B1                          | B2                          | B3                 |
|-----------------------------------|-----------------------------|-----------------------------|--------------------|
| C1 = wordList is empty             | []                          | ["apple", "money"]          |                    |
| C2 = number of words in wordList   | []                          | ["apple"]                   | ["apple", "money"] |
| C3 = wordList has duplicate words  | ["apple", "apple", "cider"] | ["apple", "money", "cider"] |                    |


**Combine partitions to define test requirements**
- Assumption: choose All possible combinations (ACoC)
- Test requirements -- number of tests (upper bound) = 2*3*2 = 12 <br>
  ACoC = (True, 0, True), (True, 0, False), (True, 1, True), (True, >1, True), (True, 1, False), (True, >1, False), (False, 0, True), (False, 1, True), (False, >1, True), (False,0, False), (False,1, False), (False,>1, False)

| Characteristic                  | B1  | B2  | B3 |
|--------------------------------|-----|-----|----|
| C1 = wordList is empty         | A   | B   |    |
| C2 = number of words in wordList | x | y | z  |
| C3 = wordList has duplicate words | 1  | 2  |    |

**ACoC = (A,x,1), (A,y,1), (A,z,1), (B,x,1), (B,y,1), (B,z,1), (A,x,2), (A,y,2), (A,z,2), (B,x,2), (B,y,2), (B,z,2)**

**Derive Test**

| Test | wordList                    | Expected result                                                                           |
|------|-----------------------------|-------------------------------------------------------------------------------------------|
| T1: (True, 0, False)   | []                          | []                                                                                        |
| T2: (False, >1, True)  | ["apple", "apple", "cider"] | randomly select and return a word from the wordList (e.g., "apple" or "cider")            |
| T3: (False, 1, False)  | ["apple"]                   | "apple"                                                                                   |
| T4: (False, >1, False) | ["apple", "money", "cider"] | randomly select and return a word from the wordList (e.g., "apple" or "money" or "cider") |



<h3>6. ชื่อของ test case: testPrintWinningMessage</h3>

**จุดประสงค์ของ test case:** เพื่อยืนยันว่า method `testPrintWinningMessage` สามารถตรวจสอบ `printWinningMessage()` method ว่าสามารถใช้งานได้และมีการแสดงข้อความเเสดงผลว่าผู้เล่นนั้น ชนะการเล่นเกมครั้งนี้เเล้วพร้อมทั้งแสดง คำที่ถูกต้อง และ definition link เพื่อให้มั่นใจว่ามี game's feedback system functions ที่ถูกต้อง.

**Interface-Based Characteristics:**

1. **Identify testable functions:**
    - `testWiningMessage()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:**
        - `userWord` (String)
        - `chosenWord` (String)
        - `youWonMessage` (String)
    - **Return type:** String
    - **Return value:** The printed message should contain: "CONGRATULATIONS! YOU WON! :)\n The word's definition: https://www.merriam-webster.com/dictionary/"
    - **Exceptional behavior:** -

3. **Model the input domain:**

    - **Develop characteristics**
        - `C1`: `userWord` is an empty string
        - `C2`: `chosenWord` is an empty string
        - `C3`: `youWinMessage` is empty

**Partitioning Characteristics**

| Characteristic               | B1    | B2    |
|-----------------------------|-------|-------|
| C1: userWord is empty       | True  | False |
| C2: ChosenWord is empty     | True  | False |
| C3: youWin Message is empty | True  | False |


**Identify Values**

| Characteristic               | B1   | B2                            |
|-----------------------------|------|-------------------------------|
| C1: userWord is empty       | ‘’   | ‘apple’                       |
| C2: ChosenWord is empty     | ‘ ’  | ‘apple’                       |
| C3: youWin Message is empty | ‘’   | ‘CONGRATULATIONS! YOU WON! :)’ |


**Derive Test**

| Test | userWord | ChosenWord | youWin Message | Expected value                                         |
|------|----------|------------|----------------|-------------------------------------------------------|
| T1   | ‘’       | ‘’         | ‘’             | The printed message should contain an empty string.   |
| T2   | ‘’       | ‘’         | ‘CONGRATULATIONS! YOU WON! :)’ | The printed message should contain an empty string.   |
| T3   | ‘’       | ‘apple’    |                | The printed message should contain an empty string.   |
| T4   | ‘’       | ‘apple’    | ‘CONGRATULATIONS! YOU WON! :)’ | The printed message should contain an empty string.   |
| T5   | ‘apple’  | ‘apple’    | ‘’             | The printed message should contain an empty string.   |
| T6   | ‘apple’  | ‘’         | ‘’             | The printed message should contain an empty string.   |
| T7   | ‘apple’  | ‘apple’    | ‘CONGRATULATIONS! YOU WON! :)’ | The printed message should contain "CONGRATULATIONS! YOU WON! :)\nThe word's definition: https://www.merriam-webster.com/dictionary/" |
| T8   | ‘apple’  | ‘’         | ‘CONGRATULATIONS! YOU WON! :)’ | The printed message should contain an empty string.   |


**Functionality-Based Characteristics:**

1. **Identify testable functions:**
    - `testWiningMessage()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:**
        - `userWord` (String)
        - `chosenWord` (String)
        - `youWonMessage` (String)
    - **Return type:** String
    - **Return value:** The printed message should contain "CONGRATULATIONS! YOU WON! :)\nThe word's definition: https://www.merriam-webster.com/dictionary/"

3. **Model the input domain:**

    - **Develop characteristics**
        - `C1`: `userWord` is valid
        - `C2`: `chosenWord` is in the list
        - `C3`: `youWinMessage` is valid


**Partitioning Characteristics**

| Characteristic               | B1   | B2          | B3     |
|-----------------------------|------|-------------|--------|
| C1: userWord is valid       | True | False       |        |
| C2: ChosenWord is in list   | Valid | Not valid | empty  |
| C3: youWin Message is valid | True | False       |        |


**Identify Values**

| Characteristic               | B1   | B2                                  | B3                           |
|-----------------------------|------|-------------------------------------|------------------------------|
| C1: userWord is valid       | ‘’   | ‘’                                |                              |
| C2: ChosenWord is in list   | ["apple", "water", "ready", "lemon", "grape"] | ‘cup’ | ‘’                         |
| C3: youWin Message is valid | ‘’   | ‘CONGRATULATIONS! YOU WON! :)’     |                              |

**Combine Partitions to define test requirements**
- Assumption: Multiple Base Choice(MBCC)

| Characteristic               | B1 | B2 | B3 |
|-----------------------------|----|----|----|
| C1: userWord is valid       | A  | B  |    |
| C2: ChosenWord is in list   | x  | y  | z  |
| C3: youWin Message is valid | 1  | 2  |    |

**Test Requirements -- number of tests(upper bound)**
- Base: A,x,1 / B,x,1
  Number of tests: 2+(2*(2-2))+(2*(3-1))+(2*(2-1)) = 8 <br>
  (A,x,1) , (A,y,1) , (A,z,1) , (A,x,2) , (B,y,1) , (B,x,1) , (B,z,1) , (B,x,2)


**Derive Test**

| Test | userWord                                    | ChosenWord | youWinMessage                | Expected values                            |
|------|--------------------------------------------|------------|------------------------------|--------------------------------------------|
| T1   | ["apple", "water", "ready", "lemon", "grape"] | ‘apple’    | ‘CONGRATULATIONS! YOU WON! :)’ | ‘CONGRATULATIONS! YOU WON! :)’               |
| T2   | ["apple", "water", "ready", "lemon", "grape"] | ‘’         | ‘CONGRATULATIONS! YOU WON! :)’ | The printed message should contain an empty string. |
| T3   | ‘["apple", "water", "ready", "lemon", "grape"] | ‘’         | ‘CONGRATULATIONS! YOU WON! :)’ | The printed message should contain an empty string. |
| T4   | ["apple", "water", "ready", "lemon", "grape"] | ‘water’    | ‘’                           | Error exception                            |
| T5   | ‘["apple", "water", "ready", "lemon", “sun”, "grape"] | ‘’         | ‘CONGRATULATIONS! YOU WON! :)’ | Error exception                            |
| T6   | ‘["apple", "water", "ready", "lemon", “sun”, "grape"] | ‘ready’    | ‘CONGRATULATIONS! YOU WON! :)’ | Error exception                            |
| T7   | ‘["apple", "water", "ready", "lemon", “sun”, "grape"] | ‘’         | ‘CONGRATULATIONS! YOU WON! :)’ | Error exception                            |
| T8   | ‘["apple", "water", "ready", "lemon", “sun”, "grape"] | ‘lemon’    | ‘’                           | Error exception                            |


<h3>7. ชื่อของ test case: testReadDictionary</h3>

**จุดประสงค์ของ test case:** เพื่อทดสอบว่าสามารถเปิดและอ่านข้อมูลในไฟล์เพื่อสร้างรายการคำศัพท์จากข้อมูลนั้น เพื่อนำไปใช้ในเกมได้.

**Interface-Based Characteristics:**

File: Wordle.java

1. Identify testable functions:
    - `testReadDictionary()`

2. Identify parameters, return types, return values, and exceptional behavior:
    - Parameters: `fileName` (String)
    - Return type: `List<String>`
    - Return value: `wordList` เป็นรายการคำศัพท์

**Exceptional Behavior:**
If the method encounters an exception during the file reading process, it catches the exception and prints an error message.

**Model the input domain:**

Develop characteristics
- C1 = File Existence

**Partitioning Characteristics**

| Characteristic | B1   | B2   |
|----------------|------|------|
| C1: File existence | True | False |


**Identify Values**

| Characteristic        | B1              | B2              |
|-----------------------|-----------------|-----------------|
| C1: File existence    | "Dictionary.txt" | "NonExistFile.txt" |


**Combine partitions to define test requirements**
- Assumption: Choose All Possible Combinations (ACoC)
- Test Requirements -- number of tests (upper bound) = 2
  (C1,B1) , (C1,B2)

**Derive Test**

| Test  | Filename            | Expected              |
|-------|---------------------|-----------------------|
| T1    | "Dictionary.txt"    | Return wordList       |
| T2    | "NonExistFile.txt"  | WordList is empty     |

### Functionality-Based Characteristics

**File:** wordle.java

1. **Identify testable functions:**
    - `testReadDictionary()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:** `fileName` (String)
    - **Return type:** `List<String>`
    - **Return value:** `wordList` เป็นคลังคำศัพท์

**Exceptional Behavior:**
If the method encounters an exception during the file reading process, it catches the exception and prints an error message.

**Model the input domain:**

**Develop characteristics**
- C1 = Type of data in File


**Identify Values**

| Characteristic           | B1         | B2     | B3           |
|--------------------------|------------|--------|--------------|
| C1: Type of data in File | Valid data | Empty  | Invalid data |


**Combine partitions to define test requirements**
- Assumption: Choose All possible combination (ACoC)
- Test Requirements -- number of tests (upper bound) = 3

**Derive Test**


| Test | Data in File                                    | Data type  | Expected                                 |
|------|-------------------------------------------------|------------|------------------------------------------|
| T1   | ["apple", "water", "ready", "lemon", "grape"]  | Valid      | Return WordList                         |
| T2   | []                                              | Empty      | Return Empty WordList                   |
| T3   | ["สวัสดี", "วันนี้", "วันดี", "ปีใหม่"] | Invalid    | Catches the exception and prints an error message |



<h3>8. ชื่อของ test case :  testPrintDefinitionLink</h3>
**จุดประสงค์ของ test case :** ทดสอบความถูกต้องของเมธอด printDefinitionLink ในคลาส English เมื่อมีการเรียกใช้งานด้วยคำศัพท์ "apple" โดย expected output ถ้ารูปแบบนี้ถูกต้อง คือเป็นไปตาม "The word's definition: https://www.merriam-webster.com/dictionary/apple"

**Interface-Based Characteristics:**
1. **Identify testable functions**
- printDefinitionLink()

2. **Identify parameters, return types, return values, and exceptional behavior**
- Parameters:  ไม่มีพารามิเตอร์ที่ถูกส่งเข้าไปในเมธอด printDefinitionLink
- Return type: เมธอด printDefinitionLink ไม่มีการส่งคืนค่า (void) คือไม่มีการส่งค่ากลับหลังจากการทำงาน
- Return value: ไม่มีค่าที่ส่งกลับเนื่องจากเมธอดไม่มีการส่งคืนค่า
- Exceptional behavior: This test does not expect any errors or exceptional behavior since it is a test for displaying the expected output of printing the definition link.

3. **Model the input domain**
- Develop characteristics
  - C1 = Input เป็น String




**Partitioning Characteristics**

| Characteristic                 | B1   | B2   |
| ------------------------------ | ---- | ---- |
| C1: Input เป็น string - True  | True | False |

**Identify Values**

| Characteristic               | B1      | B2 |
| ---------------------------- | ------- | --- |
| C1: Input เป็น string -  | "apple" | 235 |

**Combine partitions to define test requirements**
- Assumption: choose Pairwise Coverage
- Test Requirements -- number of tests (upper bound) = 2 <br>
  (C1,B1) , (C1,B2)

**Derive Test**

| Test         | Word input  | Expected                      |
| ------------ | ----------- | ------------------------------ |
| T1:("apple", True)        | "apple" |  Can print definition of words |
| T2:(235, False)         |  235   |  Can not print definition of words |


**Functionality-Based Characteristics**

1. **Identify testable functions**

- The testable function is `printDefinitionLink()` in the English class.

2. **Identify parameters, return types, return values, and exceptional behavior**

- Parameters: The method takes one parameter, which is a String representing a word (e.g., "apple").
- Return type: The method returns void, which means it doesn't return any value.
- Return value: Not applicable in this case as the method doesn't return any value.
- Exceptional behavior: This test case does not explicitly check for exceptional behavior or exceptions; it focuses on the output written to the console.

3. **Model the input domain**

**Develop characteristics**
- C1 = ลักษณะของ input
- C2 = Input สามารถสร้าง URL เพื่อเข้าถึงได้

| Characteristic             | B1                  | B2            | B3                  | B4   |
| ------------------------------  | ------------------- | ------------- |---------------------|------|
| C1: ลักษณะของ input    | Have special character | Empty String | Normal Valid string | Null |
| C2: Input สามารถสร้าง URL เพื่อเข้าถึงได้ | True              | False         | -                   | -    |


**Combine partitions to define test requirements**

**Partitioning เพื่อทำ Test Requirements**

| Characteristic        | B1   | B2   | B3   | B4   |
| -------------------------------  | ---- | ---- | ---- | ---- |
| C1                   | A    | B    | C    | D    |
| C2                   | x    | y    |      |      |
 

**Assumption: choose Pairwise Coverage (PWC)**
- Test Requirements -- number of tests (upper bound) = 4*2 = 8 <br>
  (A,x) , (A,y) , (B,x) , (B,y) , (C,x) , (C,y) , (D,x) , (D,y)

**Derive Test**

| Test  | Word input | Link                                       | Expected                         |
|-------|------------|--------------------------------------------|----------------------------------|
| T1    | “@$%#”     | https://www.merriam-webster.com/dictionary/@$%# | Can not access link               |
| T2    | “@$%#”     | https://www.merriam-webster.com/dictionary/!apple | Can access link                   |
| T3    | “ ”        | https://www.merriam-webster.com/dictionary/ | Can not print definition of words |
| T4    | “ ”        | https://www.merriam-webster.com/dictionary/ | Can not print definition of words |
| T5    | “apple”    | https://www.merriam-webster.com/dictionary/apple | Can print definition of words    |
| T6    | “tesss”    | https://www.merriam-webster.com/dictionary/tesss | Can not print definition of words |
| T7    | Null       | https://www.merriam-webster.com/dictionary/ | Can not print definition of words |
| T8    | Null       | https://www.merriam-webster.com/dictionary/ | Can not print definition of words |


<h3>9. ชื่อของ test case: testPrintingColouredAlphabet</h3>
<b>จุดประสงค์ของ test case: เพื่อยืนยันว่า method testPrintingColouredAlphabet สามารถทำงานโดยการใช้สีเขียว เหลือง และ เทา ได้ถูกต้อง</b>

**Interface-Based Characteristics:**

1. **Identify testable functions:**
    - `testPrintingColouredAlphabet`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:** `greenLetters`, `yellowLetters`, `greyLetters` (List<Character)
    - **Return type:** String
    - **Return value:** String ‘A-Z’ with color green (correct letter & index), yellow (correct only letter), gray (not correct both)

3. **Exceptional Behavior:**
    - If any of the input lists (`greenLetters`, `yellowLetters`, or `greyLetters`) contains characters that are not in the range 'A' to 'Z', the method may still attempt to print them. This could result in unexpected behavior or exceptions if the input is not properly validated.

4. **Model the input domain:**

   **Develop characteristics**
    - `C1 = greenLetters` is empty
    - `C2 = yellowLetters` is empty
    - `C3 = greyLetters` is empty

**Partitioning Characteristics**

| Characteristics              | B1    | B2    |
|------------------------------| ----- | ----- |
| C1: `greenLetters` is empty  | True  | False |
| C2: `yellowLetters` is empty | True  | False |
| C3: `greyLetters` is empty   | True  | False |

**Identify Values**

| Characteristics              | B1       | B2         |
|------------------------------| -------- | ---------- |
| C1: `greenLetters` is empty  | []       | ['A', 'B'] |
| C2: `yellowLetters` is empty | []       | ['C', 'D'] |
| C3: `greyLetters` is empty   | []       | ['E', 'F'] |

**Combine partitions to define test requirements**
- Assumption: choose Each choice Coverage 
- Test Requirements -- number of tests = 2
  (A, x, 1) , (B, y, 2)

**Partitioning เพื่อสร้าง Test Requirements (ECC)**


| Characteristics              | B1  | B2  |
|------------------------------|-----|-----|
| C1: `greenLetters` is empty  | A   | B   |
| C2: `yellowLetters` is empty | x   | y   |
| C3: `greyLetters` is empty   | 1   | 2   |

**Derive Test**

| Test             | greenLetters   | yellowLetters    | greyLetters | Expected Output |
|------------------|----------------|------------------|-------------|-----------------|
| T1: (True, True, True)  | []             | []               | []          | No output       |
| T2: (False, False, False)  | ['A', 'B']     | ['C', 'D']       | ['F']       | "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z" with color codes: A B (green), C D (yellow), F (grey) |


**Functionality-Based Characteristics:**

1. **Identify testable functions:**
    - `testPrintingColouredAlphabet`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:** `greenLetters`, `yellowLetters`, `greyLetters` (List<Character>)
    - **Return type:** String
    - **Return value:* String 'A-Z' with color green (correct letter & index), yellow (correct only letter), gray (not correct both)

3. **Exceptional Behavior:**
    - If any of the input lists (`greenLetters`, `yellowLetters`, or `greyLetters`) contains characters that are not in the range 'A' to 'Z', the method may still attempt to print them. This could result in unexpected behavior or exceptions if the input is not properly validated.

4. **Model the input domain:**
    - **Develop characteristics:**
        - `C1`: `userWord` is not empty
        - `C2`: Number of `greenLetters`
        - `C3`: Number of `yellowLetters`
        - `C4`: Number of `grayLetters`
        

**Partitioning Characteristics**

| Characteristics             | B1   | B2   | B3   |
|-----------------------------|------|------|------|
| C1: userWord is not empty   | True | False|      |
| C2: number of greenLetters  | 0    | 1    | >1  |
| C3: number of yellowLetters | 0    | 1    | >1  |
| C4: number of grayLetters   | 0    | 1    | >1  |

**Identify Values**

| Characteristics             | B1                                                      | B2                                                                                    | B3                                                                                                                      |
|-----------------------------|---------------------------------------------------------|---------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| C1: number of greenLetters  | A B C D E F G H I J K L M N O P Q R S T U V W X Y Z  | A B <span style="color:green">C</span> D E F G H I J K L M N O P Q R S T U V W X Y Z  | A B <span style="color:green">C</span> <span style="color:green">D</span> E F G H I J K L M N O P Q R S T U V W X Y Z   |
| C2: number of yellowLetters | A B C D E F G H I J K L M N O P Q R S T U V W X Y Z  | A B <span style="color:yellow">C</span> D E F G H I J K L M N O P Q R S T U V W X Y Z | A B <span style="color:yellow">C</span> <span style="color:yellow">D</span> E F G H I J K L M N O P Q R S T U V W X Y Z |
| C3: number of grayLetters   | A B C D E F G H I J K L M N O P Q R S T U V W X Y Z  | A B <span style="color:grey">C</span> D E F G H I J K L M N O P Q R S T U V W X Y Z   | A B <span style="color:grey">C</span> <span style="color:grey">D</span> E F G H I J K L M N O P Q R S T U V W X Y Z     |
| C4: userWord is not empty   | "apple"                                                | ""                                                                                    |                                                                                                                         |

**Combine partitions to define test requirements**
- Assumption: choose Each choice Coverage
- Test Requirements -- number of tests = 3 <br>
  (N, A, x, 1), (M, B, z, 2), (M, C, y, 3) <br>
  (False, 0, 0, 0), (True, 1, >1, 1), (True, >1,1, >1)



**Partitioning เพื่อสร้าง Test Requirements (ECC)**


| Characteristics             | B1  | B2  | B3  |
|-----------------------------|-----|-----|-----|
| C1 = userWord is not empty  | M   | N   |     |
| C2 = number of greenLetters | A   | B   | C   |
| C3 = number of yellowLetters | x   | y   | z   |
| C4 = number of grayLetters | 1   | 2   | 3   |


| Test | userWord | greenLetters                                                                                                          | yellowLetters                                                                                                                                             | greyLetters                                                                         | Expected result                                                                                                                                                                                                                                                                                                                                                                      |
| ---- | -------- |-----------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| T1   | " "      | A B C D E F G H I J K L M N O P Q R S T U V W X Y Z                                                                   | A B C D E F G H I J K L M N O P Q R S T U V W X Y Z                                                                                                       | A B C D E F G H I J K L M N O P Q R S T U V W X Y Z                                 | The word does not have 5 letters. Please, submit a new 5-letter word.                                                                                                                                                                                                                                                                                                                |
| T2   | "Cider"  | A B C D E F G H I J K L M N O P Q <span style="color:green">R</span> S T U V W X Y Z                                  | A B <span style="color:yellow">C</span> <span style="color:yellow">D</span> <span style="color:yellow">E</span> F G H I J K L M N O P Q R S T U V W X Y Z | A B C D E F G H <span style="color:grey">I</span> J K L M N O P Q R S T U V W X Y Z | Result: <span style="color:yellow">C</span><span style="color:grey">I</span><span style="color:yellow">D</span><span style="color:yellow">E</span><span style="color:green">R</span> <br> A B <span style="color:yellow">C</span> <span style="color:yellow">D</span> <span style="color:yellow">E</span> F G H I J K L M N O P Q <span style="color:green">R</span> S T U V W X Y Z |
| T3   | "Apple"  | <span style="color:green">A</span> B C D E F G H I J K <span style="color:green">L</span> M N O P Q R S T U V W X Y Z | A B C D <span style="color:yellow">E</span> F G H I J K L M N O P Q R S T U V W X Y Z                                                                     | A B C D E F G H I J K L M N O <span style="color:grey">P</span> Q R S T U V W X Y Z | Result: <span style="color:green">A</span><span style="color:grey">P</span><span style="color:grey">P</span><span style="color:green">L</span><span style="color:yellow">E</span> <br> <span style="color:green">A</span> B C D <span style="color:yellow">E</span> F G H I J K <span style="color:green">L</span> M N O <span style="color:grey">P</span> Q R S T U V W X Y Z                                       |


<h3>ชื่อของ test case: testPrintFirstWordRequest</h3>
**จุดประสงค์ของ test case:** เป็นการทดสอบการทำงานของฟังก์ชัน printFirstWordRequest ของการสร้างข้อความและการพิมพ์ออกมา ซึ่งถ้าฟังก์ชันทำงานถูกต้อง จะพิมพ์ข้อความ "Please write down your first guess:" และ test case จะผ่าน แต่ถ้ามีข้อผิดพลาดในการสร้างหรือพิมพ์ข้อความ test case จะล้มเหลวและต้องตรวจสอบแก้ไขให้ถูกต้องก่อนที่จะผ่านการทดสอบ

**Interface-Based Characteristics:**

File: English.java, Spanish.java

1. **Identify testable functions:**
    - `testPrintFirstWordRequest()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - Parameters: None
    - Return type: None
    - Return value: None

**Model the input domain:**

Develop characteristics
- `C1`: Message is empty

**Partitioning Characteristics**

| Characteristic         | B1    | B2    |
| ----------------------- | ----- | ----- |
| C1: Message is empty   | True  | False |

**Identify Values**

| Characteristic   | B1    | B2    |
| ---------------- | ----- | ----- |
| C1               | “ ”   | “Hi”  |

**Combine partitions to define test requirements**
- Assumption: choose Pairwise coverage (PWC)
  - Test requirements -- number of tests (upper bound) = 2 <br>
(C1, B1 ) (C2, B2)

**Derive Test**

| Test Case | Message | Expected Result |
| --------- | ------- | ---------------- |
| T1        | “ ”     | “ ”              |
| T2        | “Hi”   | “Hi”             |

**Functionality-Based Characteristics**

1. **Identify testable functions:**
- `testPrintFirstWordRequest`

**Tested Function:**
- `askForFirstGuess()` ใน `English` class

2. **Identify parameters, return types, return values, and exceptional behavior:**
- **Parameters:** None
- **Return type:** None
- **Return value:** None

3. **Model the Input Domain:**

   - C1 = Print Message contains "Please write down your first guess."
   - C2 = `askForFirstGuess()` can be called.

**Partitioning Characteristics**

| Characteristic                                 | B1   | B2   |
| -------------------------------------------- | ---- | ---- |
| C1 = Print Message contains "Please write down your first guess" | True | False |
| C2 = askForFirstGuess() can call back         | True | False |

**Identify Values**

| Characteristic                                     | B1   | B2    |
| -------------------------------------------------- | ---- |-------|
| C1 = Print Message contains | "Please write down your first guess"  | []    |
| C2 = askForFirstGuess() can call back                | True | False |

**Combine partitions to define test requirements**
- Assumption: choose Pairwise coverage (PWC)
  - Test requirements -- number of tests (upper bound) = 2*2 = 4 <br>
(C1, B1) (C2, B2) (C2, B1) (C2, B2)

**Derive Test**

| Test Case                              | Actual                                 | Expected Result                        |
| -------------------------------------- | -------------------------------------- | -------------------------------------- |
| T1                                     | "Please write down your first guess:" | "Please write down your first guess:" |
| T2                                     | "[]"                                   | ""                                     |
| T3                                     | T                                      | "Please write down your first guess:" |
| T4                                     | F                                      | Not contains "Please write down your first guess:" |


**Copyright (C) 2023 Princhon - All Rights Reserved * You may use, distribute and modify this code under the terms of the MIT license. **
