
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



**5. ชื่อของ test case: testGetRandomWord**

**จุดประสงค์ของ test case:** เพื่อตรวจสอบว่าคำศัพท์ที่ได้มาจาก `getRandomWord()` อยู่ใน `wordList` หรือไม่ ถ้าคำศัพท์ที่ได้มาอยู่ใน `wordList` ก็จะแสดงผล test ผ่าน (pass) ถ้าไม่อยู่ใน `wordList` ก็จะแสดงผล test ไม่ผ่าน (fail).

**Interface-Based Characteristics:**

1. **Identify testable functions:**
    - `testGetRandomWord()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:** None
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

| Characteristic               | B1  | B2                        |
|-----------------------------|-----|---------------------------|
| C1 = wordList is empty      | []  | ["apple", "banana", "cherry"] |

**Derive Test**

| Test | wordList         | Expected result                               |
|------|------------------|-----------------------------------------------|
| T1   | []               | return null                                   |
| T2   | ["apple", "cherry"] | randomly select and return a word from the wordList (e.g., "apple" or "cherry") |

**Functionality-Based Characteristics**

1. **Identify testable functions:**
    - `testGetRandomWord()`

2. **Identify parameters, return types, return values, and exceptional behavior:**
    - **Parameters:** None
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

| Characteristic                     | B1                   | B2                            | B3                           |
|-----------------------------------|----------------------|-------------------------------|------------------------------|
| C1 = wordList is empty             | []                   | ["apple", "banana"]           |                              |
| C2 = number of words in wordList   | []                   | ["apple"]                     | ["apple", "banana"]         |
| C3 = wordList has duplicate words  | ["apple", "apple", "cherry"] | ["apple", "banana", "cherry"] |                              |


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

| Test | wordList                       | Expected result                                 |
|------|--------------------------------|-------------------------------------------------|
| (True, 0, False)   | []                 | []                                              |
| (False, >1, True)  | ["apple", "apple", "cherry"] | randomly select and return a word from the wordList (e.g., "apple" or "cherry") |
| (False, 1, False)  | ["apple"]           | "apple"                                         |
| (False, >1, False) | ["apple", "banana", "cherry"] | randomly select and return a word from the wordList (e.g., "apple" or "banana" or "cherry") |


