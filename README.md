# 💱 Conversor de Moedas em Java
##

---
👉  ![Badge-Conversor.png](Badge-Conversor.png)

##

Bem-vindo ao **Conversor de Moedas**!  
Este projeto foi desenvolvido em Java e utiliza a **ExchangeRate API** para consultar taxas de câmbio em tempo real.  
O objetivo é permitir que o usuário converta valores entre diferentes moedas de forma prática e rápida.

---

## 🚀 Funcionalidades

Consulta manual de moedas (/latest/{base_code}): Exibe uma lista com 6 moedas selecionadas (USD, ARS, BOB, BRL, CLP, COP) e salva em arquivo JSON.

Conversão automática (/pair/{base}/{target}): Retorna a taxa de conversão entre duas moedas específicas consultando a API.

Conversão de valores: O usuário informa o valor, a moeda de origem e a moeda de destino. O sistema calcula e exibe o resultado da conversão no console.

Geração de arquivo JSON:

Salvar também o resultado da conversão realizada em json.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **HttpClient / HttpRequest / HttpResponse** (para requisições HTTP)
- **Gson** (para parse e manipulação de JSON)
- **ExchangeRate API** (fonte das taxas de câmbio)
- **IntelliJ IDEA** (IDE utilizada no desenvolvimento)

📂 Estrutura do Projeto
src/ 

├── Main.java                       # Classe principal com interação via console

├── ConsultarMoedaManualmente.java  # Consulta manual (endpoint /latest)

├── ConsultarMoedaAutomaticamente.java # Consulta automática (endpoint /pair)

├── Moeda.java                      # Record para mapear resposta JSON

├── MoedaPair.java                  # Record específico para conversão automática

├── GeradorArquivo.java             # Classe para salvar dados em JSON

└── Config.java                     # Classe utilitária para armazenar a APIKEY


---

## 📖 Instruções do Menu do Usuário

Ao executar o programa, o usuário terá acesso a um menu interativo no console:

O sistema exibe o painel de opções

Painel de opções:
1 - Converter moedas

Digite 'sair' para encerrar

Escolha:

Opção 1 – Converter moedas

##
O usuário informa o valor numérico que deseja converter.

Em seguida, digita a moeda de origem (ex: USD, BRL, ARS).

Depois, digita a moeda de destino (ex: USD, BRL, ARS).

O sistema valida os códigos de moeda (padrão ISO-4217).

Se válidos, o programa consulta a API, calcula a conversão e exibe:

Moeda base e valor informado

Moeda destino

Taxa de conversão

Resultado da conversão formatado

Opção "sair"

Encerra o programa imediatamente.

Também pode ser digitado em qualquer campo de entrada (moeda de origem ou destino) para interromper o fluxo.

Validação de entradas

Caso o usuário digite um código inválido (não no formato ISO-4217), o sistema informa o erro e solicita nova entrada.

Se houver falha na consulta da API, o programa encerra o pipeline de execução.
##


=== Conversor de Moedas ===
Bem-vindo ao conversor de MOEDAS!!!!!!!!!!!

Painel de opções:

1 - Converter moedas

Digite 'sair' para encerrar

Escolha: 1

##
Digite o valor da Conversão: 1000

Moeda De Origem (ex: USD, BRL, ARS): USD

Moeda De Destino (ex: BRL, ARS, COP): BRL
##
_______________________________________________________________________________________
Moeda Base: USD 1000,00

Moeda Destino: BRL

Taxa de conversão: 5,3439

Conversão realizada: 1000,00 USD = 5343,90 BRL
_______________________________________________________________________________________

###


## 📖 Exemplo de Uso

### Entrada:

Bem vindo ao conversor de MOEDAS!!!!!!!!!!!

Convert USD para BRL Digite o valor da Conversão: 1000 Moeda De Origem: USD Moeda De Destino: BRL


### Saída:

==== Cotação ====

ARS → 1416.67

BOB → 6.9333

COP → 3706.9494

CLP → 930.0032

USD → 1.0

BRL → 5.3439

_______________________________________________________________________________________

Moeda Base: USD 1000,00

Moeda Destino: BRL

Taxa de conversão: 5,3439

Conversão realizada: 
1000,00 USD = 5343,90 BRL

---

### Salva a conversão em um arquivo em formato json:

{

"base_code": "USD",

"target_code": "BRL",
"valor": 1000.0,

"taxa": 5.3439,

"resultado": 5343.9

}

---

## ⚙️ Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seuusuario/conversor-moedas.git

public class Config {
public static String get(String key) {
return "SUA_API_KEY_AQUI";
}
}
javac Main.java
java Main

##
📌 Próximos Passos
Implementar menu interativo com múltiplas opções.

Adicionar suporte para mais moedas além das 6 iniciais.

Criar testes automatizados para validar as conversões.

Melhorar a interface textual (exibir resultados formatados).

👨‍💻 Autor
Projeto desenvolvido por Jônathas Teles de Oliviera durante estudos de Java e integração com APIs cruso ministrado pela Alura no probama next.One & Oracle.


---
👉    ![img.png](/img.png)
