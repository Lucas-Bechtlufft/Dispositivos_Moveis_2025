# Atividade 1 – Conceitos do Android Framework

## O que é uma View no Android Framework?
Uma View no Android é um componente básico da interface do usuário. 
Cada elemento que o usuário vê e com o qual interage — como botões, textos, imagens, caixas de texto — é uma View. 
Ela representa um retângulo na tela e é responsável por desenhar seu conteúdo e responder a eventos de entrada (como toques).

---

## O que é um ViewGroup no contexto da interface do Android?
Um ViewGroup é uma View especial que pode conter outras Views (filhas), 
incluindo outras ViewGroups. Ele funciona como um contêiner ou estrutura de layout 
que organiza visualmente e hierarquicamente as Views na tela.
Exemplos incluem LinearLayout, RelativeLayout, ConstraintLayout e FrameLayout.

---

##  Qual é a função dos LayoutParams dentro de um ViewGroup?
LayoutParams é uma classe usada para informar ao ViewGroup como uma View
filha deve ser exibida. Ela define regras como largura, altura, margens e alinhamentos.
Cada ViewGroup pode ter uma versão personalizada de LayoutParams com propriedades 
adicionais específicas ao seu modo de organização.

---

##  Por que diferentes ViewGroups (como LinearLayout, ConstraintLayout, FrameLayout) utilizam subclasses específicas de LayoutParams?
Cada ViewGroup possui uma lógica própria de como posicionar e dimensionar suas Views filhas. Por isso, precisa de uma subclasse de LayoutParams que contenha informações específicas para essa lógica.
- O LinearLayout.LayoutParams permite definir pesos e margens entre os componentes.
- O ConstraintLayout.LayoutParams define regras de ancoragem entre elementos.
- O FrameLayout.LayoutParams trata margens e alinhamentos simples dentro do Frame.

Assim, essas subclasses ajudam a ViewGroup a organizar corretamente seus elementos de acordo com seu comportamento único.
