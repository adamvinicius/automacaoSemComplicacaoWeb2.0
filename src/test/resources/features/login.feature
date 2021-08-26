#language:pt
@Login
Funcionalidade: Login

  Contexto:
    Dado que a modal esteja sendo exibida
  @fecharModal
  Cenario: Fechar a modal ao clicar fora da mesma
    Quando for realizado um clique fora da modal
    Entao a janela modal deve ser fechada
  @fecharModalIcone
  Cenario: Fechar a modal ao clicar no icone fechar
    Quando for realizado um clique icone de fechar da modal
    Entao a janela modal deve ser fechada
  @createNewAccount
  Cenario: Link Create New Account
    Quando for realizado um clique em Create New Account
    Entao a pagina Create Account deve ser exibida
  @loginComSucesso
  Esquema do Cenario: Realizar login <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema
    Exemplos:
      | identificacao           | usuario | senha | remember |
      | com campos obrigatórios | chronos | Senha123 | false    |
      | todos os campos         | chronos | Senha123 | true     |
  @loginComErro
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao o sistema devera exibir uma mensagem de erro
    Exemplos:
      | identificacao    | usuario  | senha    | remember |
      | usuário inválido | invalido | Senha123    | false    |
      | senha inválida   | chronos  | invalida | false    |
  @dadosEmBranco
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Entao o botao sign in deve permanecer desabilitado
    Exemplos:
      | identificacao     | usuario | senha | remember |
      | usuário em branco |         | senha | false    |
      | senha em branco   | chronos |       | false    |



