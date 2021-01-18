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

A linguagem Dummy Lang suporta o aninhamento de comandos (laço dentro de laço).  
### **if**:
Dummy Lang também tem a função de if e else, podendo ser utilizado apenas um operando por condicao.
```
if(5 == 5)
    print('true')
endif else
    print('false')
endelse
```

## **Laços**
Para laços, Dummy Lang oferece suporte para **while** e **for**.

***

### **while**:
Síntaxe:

Exemplo de utilização:

```
int i = 0
while(i < 10)
    println('dummy')
    i = i + 1
endwhile
```
Saída:
```
dummy
dummy
dummy
dummy
dummy
dummy
dummy
dummy
dummy
dummy
```

***

### **for**:

- A variável de controle deve obrigatoriamente ser declarada anteriormente.

Exemplo de utilização:

```

int i = 2 
for(i <= 5; i = i + 1)
    print('dummy', i)
    int j = 0
    for(j < i; j = j + 1)
        print('lang ');
    endfor
    print('dummy lang')
endfor
```

## **Controlador de Fluxo**
Dummy Lang utiliza os controladores de fluxo **if** e **else**

Exemplo de utilização:
```
int numero = 5
if(numero <= 5)
    print('é menor ou igual a 5')
endif else
    print('não é menor ou igual a 5')
endelse

```
Saída:
```
é menor ou igual a 5
```
***
***
