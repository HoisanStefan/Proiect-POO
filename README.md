# Proiect-POO

The purpose of the project is to simulate the process flow of an energy service.
Using **Factory Pattern** as well as **Singleton Pattern**, 2 main entities are built:
  * **Consumers** - They need to sign a contract with a distributor at the beginning of every month and pay for their service. Every month, a salary will be received. They can choose to indebt to their distributor if they don't have enough money, following this they'll need to pay the debt with a penalty. If they still cannot afford this payment, they'll go bankrupt.
  * **Distributors** - They recalculate their contract costs depending on the number of consumers they currently have. They receive the money from their consumers. At the end of every month, they'll have to pay their expenses which can be higher than their budget, in which case it cause bankrupcy.
