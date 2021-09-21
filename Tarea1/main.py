import re

def read_file(filename):
    text_list = []
    file = open(filename)
    for line in file:
        line = line.strip()
        text_list.append(line)
    file.close()
    return text_list

def write_file(filename,text_list):
    file = open(filename,"w")
    for line in text_list:
        file.write(line+"\n")

regex = [
    "(U)([0-9])",
    "(D)([0-9])",
    "(<)([0-9])",
    "(>)([0-9])",
    "(A)",
    "(B)",
    "(X)([U|D|<|>])([0-9])",
    "(Y)([U|D|<|>])([0-9])",
    "(L)([c|e])",
    "(R)",
    "(Z)",
    "(S)([c|e])"
]

regex_condition = "(\?)([U|D|<|>])([0-9])(\?[U|D|<|>][0-9])*(U[0-9]|D[0-9]|<[0-9]|>[0-9]|A|B|X[U|D|<|>]|Y[U|D|<|>]|L[c|e]|R|Z|S[c|e])"
regex.append(regex_condition)



def U(position: list, n: int, number: int) -> None:
    position[1] -= number
    position[1] %= n 

def D(position: list, n: int, number: int) -> None:
    position[1] += number
    position[1] %= n 

def minus(position: list, n: int, number: int) -> None:
    position[0] -= number
    position[0] %= n

def major(position: list, n: int, number: int) -> None:
    position[0] += number
    position[0] %= n

def A(position: list, matriz: list) -> None:
    x,y = position
    matriz[y][x] += 1

def B(position: list, matriz: list) -> None:
    x,y = position
    matriz[y][x] -= 1

def dir_value(position:list, matriz: list ,dir: str, number: int, n: int) -> int:
    if dir == "U":
        U(position,n,number)
        x,y = position
        U(position,n,-number)
        return matriz[y][x]
    if dir == "D":
        D(position,n,number)
        x,y = position
        D(position,n,-number)
        return matriz[y][x]
    if dir == "<":
        minus(position,n,number)
        x,y = position
        minus(position,n,-number)
        return matriz[y][x]
    if dir == ">":
        major(position,n,number)
        x,y = position
        major(position,n,-number)
        return matriz[y][x]
    return 1
         
def X(position: list, matriz: list, dir: str, number: int) -> None:
    x,y = position
    matriz[y][x] *= dir_value(position,matriz,dir,number,len(matriz))

def Y(position: list, matriz: list, dir: str, number: int) -> None:
    x,y = position
    number = dir_value(position,matriz,dir,number)
    if number == 0: return
    matriz[y][x] /= number

def L(position: list, matriz: list, c_or_e: str) -> None:
    x,y = position
    if c_or_e == "c" and (32 <= matriz[y][x] <= 127):
        print(chr(matriz[y][x]))
        return
    print(matriz[y][x])

def S(matriz: list, c_or_e: str) -> None:
    for y in matriz:
        for x in y:
            if c_or_e == "c" and (32 <= x <= 127):
                print(chr(x),end="")
            elif c_or_e == "e":
                print(x,end="")

def R(position: list, matriz: list) -> None:
    x,y = position
    matriz[y][x] = 0

def Z(matriz: list) -> None:
    y = 0
    while y < len(matriz):
        x = 0
        while x < len(matriz[y]):
            matriz[y][x] = 0
        y += 1

def compiler_line(line):
    level = 0
    list_exp = []
    while len(line) > 0:
        if level < 0:
            return {
                "e": True,
                "list_exp": list_exp
            }
        while len(list_exp) <= level: list_exp.append([])
        if line[0] == "(":
            level += 1
            line = line[1:]
        elif line[0] == ")":
            level -= 1
            line = line[1:]
        else:
            flag = True
            for exp in regex:
                value = re.search("^"+exp,line)
                if value:
                    list_exp[level] += [value]
                    line = line[value.span()[1]:]
                    flag = False
            if flag:
                return {
                    "e": True,
                    "list_exp": list_exp
                }

    if level != 0: 
        return {
            "e": True,
            "list_exp": list_exp
        }

    temp_list = []
    for exp in list_exp[::-1]:
        temp_list += exp
    return {
        "e": False,
        "list_exp": temp_list
    }
def process_command(exp, matriz, position):
    if exp.group(1) == "U": U(position,len(matriz),int(exp.group(2)))
    elif exp.group(1) == "D": D(position,len(matriz),int(exp.group(2)))
    elif exp.group(1) == ">": major(position,len(matriz),int(exp.group(2)))
    elif exp.group(1) == "<": minus(position,len(matriz),int(exp.group(2)))
    elif exp.group(1) == "A": A(position,matriz)
    elif exp.group(1) == "B": B(position,matriz)
    elif exp.group(1) == "X": X(position,matriz,exp.group(2),int(exp.group(3)),)
    elif exp.group(1) == "Y": Y(position,matriz,exp.group(2),int(exp.group(3)))
    elif exp.group(1) == "L": L(position,matriz,exp.group(2))
    elif exp.group(1) == "R": R(position,matriz)
    elif exp.group(1) == "Z": Z(matriz)
    elif exp.group(1) == "S": S(matriz,exp.group(2))

def process_condition(exp,matriz, position):
    str_temp = exp.group()
    while len(str_temp) > 0:
        temp = re.search("^"+regex_condition, str_temp)
        if temp and dir_value(position, matriz, temp.group(2), int(temp.group(3)), len(matriz)) > 0:
            str_temp = str_temp[( len(temp.group(1) + temp.group(2) + temp.group(3)) ):]
        elif temp: str_temp = ""
        else:
            for e in regex:
                e_temp = re.search(e, str_temp)
                if e_temp: process_command(e_temp, matriz, position)
            str_temp = ""

def inter_line(list_exp,matriz,position = [0,0]):
    for exp in list_exp:
        if exp.group(1) == "?": process_condition(exp,matriz,position)
        else: process_command(exp, matriz, position)

code = read_file("codigo.txt")
n = int(code[0])
matriz = [[0 for __ in range(n)] for _ in range(n)]

operations = code[1:]

for op in operations:
    resp = compiler_line(op)
    if not resp["e"]:
        inter_line(resp["list_exp"],matriz)
    else:
        print(op)







