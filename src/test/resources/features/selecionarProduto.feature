#languade: pt
 # Funcionalidade: Selecionar Produto na Loja
   # : Selecionar Produto com Sucesso
    #  Dado: que acesso a loja SauceDemo
     #   Quando preencho o usuario e senha
      #  E clica em login
       # E exibe o link do carrinho de compras
        # Quando clica no produto "Sauce Labs Backpack"
  #GIVEN = DADO WHEN= QUANDO THEN= ENTÃO
  #Arquivo de Feature:

  Feature: Selecionar Produro na Loja
    Scenario: Selecionar produto com sucesso
      Given Acesso a loja SauceDEemo
      When Quando preencho o usuario "standard_user e senha "secret_sauce"
      And clico em login
      Then Mostra o titulo da pagina produtos
      And Mostra o link do carrinho
      When Eu clico no produto "Sauce Labs Backpack"
      Then Verifico o titulo do produto "Sauce Labs Backpack"
      And E verifico o preço "$29.99"
      When CLico em adicionar no carrinho
      And Clico no icone do carrinho
      Then Verifica o titulo da pagina "Your Cart"
      And Verifico o titulo da produto "Sauce Labs Backpack"
      And E verifico a quantidade "1"
      And E verifico o preço "$29.99"




