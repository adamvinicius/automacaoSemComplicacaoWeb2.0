#language:pt

Funcionalidade: Login

  Contexto:
    Dado que a modal esteja sendo exibida

  Cenario: Fechar a modal ao clicar fora da mesma
    Quando for realizado um clique fora da modal
    Entao a janela modal deve ser fechada

  Cenario: Fechar a modal ao clicar no icone fechar
    Quando for realizado um clique icone de fechar da modal
    Entao a janela modal deve ser fechada

  Cenario: Link Create New Account
    Quando for realizado um clique em Create New Account
    Entao a pagina Create Account deve ser exibida

  Esquema do Cenario: Realizar login <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema
    Exemplos:
      | identificacao           | usuario | senha | remember |
      | com campos obrigatórios | chronos | senha | false    |
      | todos os campos         | chronos | senha | true     |

  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao o sistema devera exibir uma mensagem de erro
    Exemplos:
      | identificacao    | usuario  | senha    | remember |
      | usuário inválido | invalido | senha    | false    |
      | senha inválida   | chronos  | invalida | false    |

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


