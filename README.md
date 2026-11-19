# Apresentação PDM — Interfaces Android, Jetpack Compose e UX

## Sobre a aplicação

Esta aplicação Android foi desenvolvida como apoio a uma apresentação prática sobre **construção de interfaces Android e experiência do utilizador (UX)**. Através de formulários simples, permite comparar a abordagem tradicional **XML + View Binding** com **Jetpack Compose** e explorar a adaptação a diferentes orientações, os componentes **Material Design 3**, os temas **Light/Dark** e algumas boas práticas de **acessibilidade**.

O objetivo é **aprender através da observação e da experimentação**: executar o formulário, abrir o ficheiro que o implementa, alterar um elemento e observar o resultado. Os exemplos são demonstrativos e não armazenam os dados submetidos.

### Preparação

1. Abrir a pasta do projeto no **Android Studio**.
2. Sincronizar o projeto com o Gradle e selecionar um emulador ou dispositivo Android compatível (**Android 10 / API 29 ou superior**).
3. Executar `app`. O ecrã inicial apresenta dois botões: **XML + View Binding** e **Jetpack Compose**.
4. Para consultar as demonstrações adicionais, abrir os ficheiros indicados na Parte 3. Alguns exemplos destinam-se a ser explorados pelo **Preview**, ou a ser selecionados temporariamente no código, e não têm botão próprio no menu.



## Parte 1 — Interfaces tradicionais: XML + View Binding

Nesta implementação, a estrutura visual é definida num **ficheiro XML**, enquanto a lógica dos botões, a leitura dos campos e a validação são tratadas numa **Activity Kotlin**. O **View Binding** permite aceder aos elementos do layout através de referências geradas automaticamente.

**Ficheiros principais:**

- `app/src/main/res/layout/activity_xml_form.xml` — estrutura visual com `ConstraintLayout`, campos de texto, seleção do perfil, botões e mensagem de resultado.
- `app/src/main/java/com/example/apresentacaopdm/XmlFormActivity.kt` — eventos, validações e atualização dos elementos através do View Binding.
- `app/src/main/java/com/example/apresentacaopdm/MainActivity.kt` — navegação a partir do menu principal.

### Passo a passo

1. Executar a aplicação e selecionar **XML + View Binding**.
2. Preencher os campos **Nome**, **Email** e **Idade**; selecionar **Pessoal** ou **Profissional**.
3. Carregar em **Submeter Formulário** e observar o resultado apresentado no ecrã.
4. Repetir o teste deixando um campo vazio ou introduzindo um email ou idade inválidos. Observar as mensagens de erro.
5. Abrir `activity_xml_form.xml` no Android Studio e identificar os elementos `EditText`, `RadioGroup`, `Button` e `TextView`, bem como as restrições do `ConstraintLayout`.
6. Abrir `XmlFormActivity.kt` e localizar `ActivityXmlFormBinding.inflate(...)`, `setOnClickListener`, as condições de validação e `binding.tvResult.text`.
7. Relacionar o que aconteceu no ecrã com o código: **a Activity lê os valores e modifica diretamente as Views para apresentar erros e resultados**.

**Com isto indentificamos:** a separação entre layout XML e lógica Kotlin, o papel do View Binding, a gestão explícita de eventos e atualizações da interface.



## Parte 2 — Jetpack Compose

No **Jetpack Compose**, a interface é descrita diretamente em Kotlin através de funções `@Composable`. Os componentes são combinados com layouts como `Column` e personalizados através de `Modifier`. A interface apresentada depende do **estado** atual.

**Ficheiro principal:** `app/src/main/java/com/example/apresentacaopdm/ComposeFormActivity.kt`.

### Passo a passo

1. Voltar ao menu principal e selecionar **Jetpack Compose**.
2. Identificar os campos **Nome**, **Email** e **Idade**, o botão **Submeter** e o botão do contador.
3. Introduzir dados válidos e inválidos para observar como a mensagem do formulário é apresentada.
4. Carregar várias vezes em **Clicado 0 vezes** e observar que o texto acompanha o valor do contador.
5. No Android Studio, abrir `ComposeFormActivity.kt` e localizar `setContent`, `@Composable fun Formulario()`, `Column`, `TextField`, `Button` e `Modifier`.
6. Procurar `remember { mutableStateOf(...) }`: estas variáveis guardam o nome, o email, a idade, a mensagem e o contador durante as recomposições.
7. No `TextField`, observar a ligação entre `value` e `onValueChange`. No contador, observar que `contador++` atualiza o estado e o `Text` passa a mostrar o novo valor, **sem ser necessário procurar uma View e alterar manualmente o seu texto**.

**Com isto identificamos:** composição de funções, personalização com `Modifier`, **estado e recomposição**. Comparando com a Parte 1, em XML a Activity atualiza as Views. Já em Compose, a UI é descrita em função do estado.



## Parte 3 — Interfaces adaptativas, Material Design 3 e UX

Esta parte demonstra que uma interface não deve apenas funcionar: deve continuar **organizada, legível e utilizável** quando o tamanho ou a orientação do ecrã muda e quando o utilizador escolhe outro tema ou precisa de condições de acessibilidade diferentes.

### 3.1 — Adaptação a Portrait e Landscape

**XML:**

- `app/src/main/res/layout/activity_xml_form.xml` — layout habitual.
- `app/src/main/res/layout-land/activity_xml_form.xml` — alternativa para a orientação horizontal.

**Experimentar:** abrir o formulário XML e rodar o emulador entre **Portrait** e **Landscape**. No Android Studio, comparar os dois layouts: o Android escolhe automaticamente o recurso correspondente à orientação, mantendo os mesmos identificadores dos elementos utilizados pelo View Binding.

**Compose:**

- `app/src/main/java/com/example/apresentacaopdm/compose/ComposeAdaptiveActivity.kt`.

**Experimentar:** abrir o ficheiro e visualizar os Previews `PreviewPortrait()` e `PreviewLandscape()`. Identificar `LocalConfiguration.current` e `isLandscape`: quando a orientação é horizontal, o exemplo organiza os campos numa **Row**; na vertical, apresenta-os numa **Column**.

**Concluindo:** no XML, usamos layouts separados para diferentes orientações, selecionados automaticamente pelo Android. No Compose, adaptamos a disposição dos componentes diretamente no código Kotlin.

### 3.2 — Material Design 3

O **Material Design 3** fornece componentes e um sistema de temas para manter uma aparência consistente (cores, tipografia e formas).

**XML:** abrir `app/src/main/res/layout/activity_xml_form_material.xml` e comparar os componentes com os do layout XML original. O exemplo utiliza `TextInputLayout`/`TextInputEditText`, `MaterialButton` e `MaterialRadioButton`. Para **executar esta variante** em vez da original, em `XmlFormActivity.kt` substituir o binding ativo `ActivityXmlFormBinding` por `ActivityXmlFormMaterialBinding` nos locais assinalados pelos comentários, mantendo apenas uma versão ativa de cada declaração e inicialização.

**Compose:** abrir `app/src/main/java/com/example/apresentacaopdm/compose/MaterialDesignActivity.kt` e o `PreviewFormularioMaterial()`. Identificar `MaterialTheme`, `TextField` e `Button`. Observar também o estilo de tipografia comentado (`MaterialTheme.typography.headlineMedium`) e compará-lo com o tamanho e o peso definidos manualmente.

**Concluindo:** usar componentes e temas partilhados reduz a necessidade de definir a aparência de cada elemento individualmente.

### 3.3 — Light Mode e Dark Mode

**XML:** consultar `res/values/themes.xml`, `res/values-night/themes.xml`, `res/values/colors.xml` e `res/values-night/colors.xml`. O projeto utiliza um tema `DayNight` e define recursos de cor específicos para o modo escuro. Alternar o tema claro/escuro do dispositivo e observar o efeito nos componentes; para testar cores próprias, usar referências `@color/...` em vez de valores fixos nos layouts.

**Compose:** abrir `app/src/main/java/com/example/apresentacaopdm/compose/DarkLightModeActivity.kt`. Identificar a variável `darkMode`, a escolha entre `lightColorScheme()` e `darkColorScheme()` e a aplicação de `MaterialTheme(colorScheme = colorScheme)`. O botão inverte `darkMode`, fazendo a interface refletir o tema selecionado.

**Para executar esta demonstração Compose:** em `MainActivity.kt`, alterar temporariamente o destino do botão Compose de `ComposeFormActivity::class.java` para `DarkLightModeActivity::class.java`. Executar a aplicação e alternar entre os dois modos. No final, repor o destino original.

**Concluindo:** utilizar um sistema de temas permite centralizar as cores e a aparência da interface, evitando configurar cada componente individualmente.

### 3.4 — Acessibilidade e experiência do utilizador

A acessibilidade envolve **texto legível, contraste adequado, dimensões apropriadas, identificação dos campos e facilidade de interação**.

1. Abrir `app/src/main/java/com/example/apresentacaopdm/compose/NoAccessibilityActivity.kt` e observar o `PreviewFormularioNaoAcessivel()`.
2. Identificar os problemas introduzidos propositadamente: texto pequeno, campos sem labels e botões de dimensões reduzidas.
3. Comparar com `ComposeFormActivity.kt`, onde os campos têm identificação e tamanhos mais adequados.
4. No XML Material, consultar os comentários de `activity_xml_form_material.xml` sobre `hint`, `inputType`, `sp`, contraste e descrições acessíveis.
5. Refletir como as decisões de layout e design podem tornar um formulário mais fácil ou mais difícil de usar, mesmo quando as funcionalidades são semelhantes.

**Concluindo:** uma interface funcional não é necessariamente acessível. Testar diferentes condições de utilização e incorporar a acessibilidade desde o início faz parte da experiência de utilizador.

---

## Conclusão

Os exemplos permitem comparar duas formas de desenvolver interfaces Android: **XML + View Binding**, com layouts separados e atualização direta das Views, e **Jetpack Compose**, com interfaces declaradas em funções e dependentes do estado. Independentemente da tecnologia, boas interfaces devem considerar **adaptação ao espaço disponível, consistência visual, temas claro/escuro e acessibilidade**.