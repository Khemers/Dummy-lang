**Interpretador Dummylang**

**Alunos: Eduardo Barcaroli, Bernardo Facchi, Vinicius Mittmann e Leonardo Machado.**


## Variáveis
Para declaração de variáveis, utilizamos o comando:
```
tipo nome = valor
```
ou
```
tipo nome
```

##Int
Para armazenar numeros inteiros utilize:

```
int x
int x1
int x2
x = 1 + 2
x1 = 5
x2 = x + x1
```

## Double:
Para armazenar numeros double utilize:

```
double x
double x1
double x2
x = 1.523 + 2 
x1 = 2.594
x2 = x + x1
```

## Float:
Para armazenar numeros float utilize:

```
float x
float x1
float x2
x = 2.5 + 1.5
x1 = 3.5
x2 = x + x1
```


## String:
Para armazenar strings utilize:

```
string x
x = 'Hello' + 'World' 
x1 = 'Teste'
x2 = x + x1
```

## Operações:
Podemos utilizar as quatro operações basicas da matematica e o resto para fazer calculos matematicos.

O limite de operações é de uma operaçao.

Podemos utilizar valores negativos.

Exemplo:
```
int x
x = -550+555
```

##Entrada e Saída:
##Input:
Para entradas do teclado utilizamos input:

Síntaxe:

```
int x
input(x)
```

##Print:

Para saidas do programa utilizamos print e println:

Síntaxe:

```
string x
print(texto)
println(texto)
```
ou
```
int x
print(x)
println(x)
```

##Condições:

Dummylang tambem tem a funcao de if e else, podendo ser utilizado apenas um operando por condicao.
```
if(5 == 5)
    print('true')
endif
```

## **Laços**
Sucury utiliza duas estruturas para realizar repetições de blocos no código. São elas: **while** e **for**.

***

### **while**:
Síntaxe:

```
while(condição)
    Bloco
endwhile
```

- Repete o bloco enquanto a condição for verdadeira.

Exemplo de utilização:

```
int i = 0
while(i < 5)
    print('oi boi\n')
    i++
endwhile
```
Saída:
```
oi boi
oi boi
oi boi
oi boi
oi boi
```

***

### **for**:
Síntaxe:

```
for(variável de controle;condição;incremento)
    Bloco
endfor
```

- A variável de controle pode ser declarada anteriormente ou dentro da própria chamada (caso declarado na chamada, a váriavel só fica disponível no escopo do for);
- O bloco é repetido enquanto a condição for verdadeira;
- O incremento é realizado ao final de cada execução do bloco;

Exemplo de utilização:

```
print('1 Elefante incomoda muita gente.\n')
int i 
for(i = 2;i <= 5; i++)
    print('%i Elefantes ', i)
    for(int j = 0; j < i; j++)
        print('incomodam ');
    endfor
    print('muito mais.\n')
endfor
```
Saída:
```
1 Elefante incomoda muita gente.
2 Elefantes incomodam incomodam muito mais.
3 Elefantes incomodam incomodam incomodam muito mais.
4 Elefantes incomodam incomodam incomodam incomodam muito mais.
5 Elefantes incomodam incomodam incomodam incomodam incomodam muito mais.
```

***
***
## **Controlador de Fluxo**
Sucury utiliza os controladores de fluxo **if** e **else**

Síntaxe:

```
if(condição)
    bloco
endif
```
- Se a condição for verdadeira, o bloco é executado. Se não, o programa não executa o bloco.
```
if(condição)
    bloco 1 
else
    bloco 2 
endif
```
- Se a condição for verdadeira, o bloco 1 é executado. Se não, o bloco 2 é executado.

Exemplo de utilização:
```
int numero = 5
if(numero <= 5)
    print('é menor ou igual a 5\n')
else
    print('não é menor ou igual a 5\n')
endif
```
Saída:
```
é menor ou igual a 5
```
***
***
## **Funções**
A Sucury permite utilizar pedaços de código em funções para facilitar e maximizar na organização do código.
***
### **Definição**:
Para definir uma função, utiliza-se o **def**.
Logo após o def, temos o tipo do retorno da função **(int, float, double, string ou void)**, seguido do nome da função e seus parâmetros. Após inserir o corpo da função, utiliza-se o **enddef** para fechar a definição. Síntaxe:
```
def tipo nome(tipo param1, tipo param2)
    (bloco)
enddef
```
***
### **Retorno**:
A função pode ter 5 tipos de retorno **(int, float, double, string ou void)**. O retorno recebe o tipo definido no início da função e ele substituí a chamada da função pelo retorno quando utilizado. Exemplo:
```
def int sum(int numb1, int numb2)
    return numb1 + numb2
enddef
```
***
### **Chamada**:
Para chamar a função, utilizamos o nome da função junto aos parâmetros que serão utilizados na função. Síntaxe:
```
nomeDaFunc(param1, param2)
```
Exemplos:
```
def int sum(int numb1, int numb2)
    return numb1 + numb2
enddef
 
int numb = sum(1,2)
```
ou
```
def int sum(int numb1, int numb2)
    return numb1 + numb2
enddef
 
int a = 1
int b = 2
int numb = sum(a,b)
```