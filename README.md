## 📱 Gestão de Pedidos - Android Kotlin

Aplicação Android para gestão de pedidos em cafetaria, com cálculo em tempo real, validação de inputs e navegação entre múltiplas *Activities*.

Este projeto foi desenvolvido no âmbito da unidade curricular **UC00609**, com foco em boas práticas de desenvolvimento Android, gestão de estado da interface e experiência do utilizador.

---

## 📸 Preview

[🎥 Clique aqui para ver o vídeo de demonstração](docs/teste_gestaopedidos.webm)

---

## 🚀 Funcionalidades

### 🧠 Gestão de Estado da Interface

* Ativação dinâmica de inputs através de `CheckBox`
* Preenchimento automático da quantidade inicial (**1 unidade**)
* Bloqueio/desbloqueio de campos conforme interação do utilizador

### ⚡ Cálculo em Tempo Real

* Atualização instantânea de subtotais
* Monitorização reativa com `TextWatcher`
* Preços definidos:

  * Café: **1.00€**
  * Pão: **0.50€**
  * Chocolate: **1.20€**

### 🔄 Fluxo de Navegação (3 Activities)

1. **MainActivity**

   * Seleção de produtos
   * Validação de dados
   * Cálculo inicial

2. **PrepareActivity**

   * Simulação de processamento
   * `ProgressBar` com delay de **3 segundos**

3. **SummaryActivity**

   * Exibição do resumo final
   * Total do pedido formatado

---

## 🧩 Arquitetura & Conceitos Aplicados

* **Arquitetura**: Navegação baseada em Activities
* **Gestão de Estado**: UI reativa com `TextWatcher`
* **Comunicação**: `Intent` com Extras (chave-valor)
* **Assincronismo**: `Handler` + `Looper`
* **UI**: Layouts XML nativos

---

## 🛠️ Tecnologias

* **Linguagem**: Kotlin 1.9+
* **Plataforma**: Android SDK
* **UI**: XML (LinearLayout, RelativeLayout)
* **Build System**: Gradle

---

## ⚙️ Como Executar

### 🔹 Pré-requisitos

* Android Studio instalado
* Emulador (AVD) ou dispositivo físico

---

### 🔹 Execução via Android Studio

1. Clonar o repositório:

```bash
git clone https://github.com/Maria-Helena-Almeida/gestaopedidos.git
```

2. Abrir o projeto no Android Studio
3. Clicar em **Run ▶️**

---

### 🔹 Execução via Terminal

```bash
git clone https://github.com/Maria-Helena-Almeida/gestaopedidos.git
cd gestaopedidos
```

```bash
./gradlew clean installDebug --no-configuration-cache
```

```bash
adb shell am start -n com.mh.gestaopedidos/.MainActivity
```

---

## 📁 Estrutura do Projeto

```
app/src/main/
 ├── java/com/mh/gestaopedidos/
 │    ├── MainActivity.kt
 │    ├── PrepareActivity.kt
 │    └── SummaryActivity.kt
 ├── res/layout/
 └── AndroidManifest.xml
```

---

## 📌 Aprendizagens

Durante o desenvolvimento deste projeto foram consolidados conceitos importantes:

* Gestão de estado em interfaces Android
* Atualização reativa de UI
* Comunicação entre Activities
* Simulação de processos assíncronos
* Estruturação de aplicações Android simples

---

## 🆘 Troubleshooting

### 🔧 Erro: "Folder in use" ou falhas de build

```bash
./gradlew --stop
```

```bash
Stop-Process -Name "java" -Force -ErrorAction SilentlyContinue
```

```bash
rd /s /q .gradle
rd /s /q app/build
```

```bash
./gradlew installDebug
```

> ⚠️ O aviso *"SDK processing warning"* pode ser ignorado — trata-se apenas de incompatibilidade entre versões de ferramentas.

---

## 📈 Melhorias Futuras

* Implementação de **ViewModel + LiveData**
* Persistência de dados com **Room**
* Migração para **Jetpack Compose**
* Adição de testes unitários

---

## 👤 Autor

**Maria Helena Alves de Almeida**
💼 QA Analyst & Flow Designer| Aspiring Data Analyst | Background em Logística & Qualidade
📍 Braga, Portugal

---

## ⭐ Sobre o Projeto

Este projeto demonstra competências fundamentais em desenvolvimento Android, com foco em lógica de negócio, reatividade da interface e organização de código — servindo como base para evoluções futuras mais complexas.
