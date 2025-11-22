# 💱 Conversor de Moedas em Java

Bem-vindo ao **Conversor de Moedas**!  
Este projeto foi desenvolvido em Java e utiliza a **ExchangeRate API** para consultar taxas de câmbio em tempo real.  
O objetivo é permitir que o usuário converta valores entre diferentes moedas de forma prática e rápida.

---

## 🚀 Funcionalidades

- Consulta manual de moedas (`/latest/{base_code}`):
    - Exibe uma lista com **6 moedas selecionadas** (USD, ARS, BOB, BRL, CLP, COP).
- Conversão automática (`/pair/{base}/{target}`):
    - Retorna a taxa de conversão entre duas moedas específicas.
- Conversão de valores:
    - O usuário informa o valor, a moeda de origem e a moeda de destino.
    - O sistema calcula e exibe o resultado da conversão.
- Geração de arquivo JSON:
    - Os dados retornados pela API são salvos em arquivo para auditoria e consulta futura.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **HttpClient / HttpRequest / HttpResponse** (para requisições HTTP)
- **Gson** (para parse e manipulação de JSON)
- **ExchangeRate API** (fonte das taxas de câmbio)
- **IntelliJ IDEA** (IDE utilizada no desenvolvimento)

---

## 📂 Estrutura do Projeto

src/
├── Main.java # Classe principal com interação via console
├── ConsultarMoedaManualmente.java # Consulta manual (endpoint /latest)
├── ConsultarMoedaAutomaticamente.java # Consulta automática (endpoint /pair)
├── Moeda.java # Record para mapear resposta JSON
├── MoedaPair.java # Record específico para conversão automática
├── GeradorArquivo.java # Classe para salvar dados em JSON
└── Config.java # Classe utilitária para armazenar a APIKEY

---

## 📖 Exemplo de Uso

### Entrada:

Bem vindo ao conversor de MOEDAS!!!!!!!!!!!

Convert USD para BRL Digite o valor da Conversão: 1000 Moeda De Origem: USD Moeda De Destino: BRL


### Saída:

==== Cotação ==== ARS → 1416.67 BOB → 6.9333 COP → 3706.9494 CLP → 930.0032 USD → 1.0 BRL → 5.3439

Moeda Base: USD 1000,00 Moeda Destino: BRL Taxa de conversão (API): 5.3439 Conversão realizada: 1000,00 USD = 5343,90 BRL


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


📌 Próximos Passos
Implementar menu interativo com múltiplas opções.

Adicionar suporte para mais moedas além das 6 iniciais.

Criar testes automatizados para validar as conversões.

Melhorar a interface textual (exibir resultados formatados).

👨‍💻 Autor
Projeto desenvolvido por Jhonatan durante estudos de Java e integração com APIs.


---

👉 Esse README já está pronto para colocar no GitHub.  
Quer que eu monte também um **badge de status** (Java version, API usada, etc.) para deixar mais profissional?

