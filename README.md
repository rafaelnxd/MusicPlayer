# Player de Música Android

Integrantes:

Rafael de Novaes - RM553934  
Fabíola Falcão - RM552715  

## Funcionalidades Principais

- **Login Simples**: Permite que o usuário faça login com credenciais locais.
- **Dashboard**: Após o login, o usuário é levado a uma página de dashboard que contém botões para acessar a lista de músicas e as informações do grupo, além da opção de logout.
- **Lista de Músicas**: Exibe uma lista de músicas disponíveis para o usuário selecionar e reproduzir.
- **Reprodutor de Música**: Reproduz a música selecionada, com botões de play/pause e uma barra de progresso para avançar ou retroceder na faixa.

## Estrutura do Projeto

O projeto possui a seguinte estrutura de atividades e layouts:

- **MainActivity**: Tela de login onde o usuário insere suas credenciais.
- **DashboardActivity**: Tela de navegação principal após o login, com botões para acessar a lista de músicas, informações do grupo e realizar logout.
- **SongListActivity**: Exibe uma lista de músicas para o usuário escolher.
- **PlayerActivity**: Reproduz a música escolhida, permitindo pausar, tocar e controlar a posição da música.
- **GroupInfoActivity**: Exibe informações sobre os membros do grupo (opcional).
  
## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. **Abra o projeto no Android Studio**.
   
3. **Compile e execute o projeto** em um dispositivo ou emulador Android.

### Como Usar o Aplicativo

1. **Login**: O usuário pode realizar login utilizando credenciais pré-definidas.
   - Username: `professortop`
   - Password: `123`

2. **Dashboard**: Após o login, o usuário pode navegar até a lista de músicas ou visualizar as informações do grupo.

3. **Lista de Músicas**: Selecione uma música para reproduzir.

4. **Player de Música**: Controle a música com os botões de play/pause e mova o `SeekBar` para alterar a posição na música.
