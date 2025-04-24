# 🧪 Tests Automatisés OrangeHRM avec Selenium

![Selenium](https://img.shields.io/badge/-Selenium-43B02A?logo=selenium&logoColor=white)
![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white)
![TestNG](https://img.shields.io/badge/-TestNG-DD2233?logo=testng&logoColor=white)

## 📋 Table des Matières
- [Prérequis](#-prérequis)
- [Installation](#-installation)
- [Structure du Projet](#-structure-du-projet)
- [Tests Implémentés](#-tests-implémentés)
- [Exécution des Tests](#-exécution-des-tests)
- [Configuration](#-configuration)
- [Bonnes Pratiques](#-bonnes-pratiques)
- [Prochaines Étapes](#-prochaines-étapes)

## ⚙️ Prérequis

| Composant       | Version   |
|-----------------|-----------|
| Java JDK        | 17       |
| Maven           | 3.6.0+    |
| Navigateur      | Chrome    |

## 📥 Installation

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/Volbis/SeleniumTest.git
   cd SeleniumTest
Installer les dépendances :

bash
mvn clean install

📁 Structure du Projet
src/test/java/org/example/
└── HrmOrangeTest.java       # Classe principale de tests
pom.xml                      # Configuration Maven
README.md                    # Ce fichier
🧪 Tests Implémentés
🔐 Test de Connexion (loginTest)
Objectif : Valider le processus d'authentification

Flux :

Accès à la page de login

Saisie des identifiants valides (Admin/admin123)

Soumission du formulaire

Vérification du chargement du Dashboard

Assertions :

La page Dashboard est affichée

Le titre contient "OrangeHRM"

👥 Test d'Ajout d'Employé (ajoutEmployeTest)
Objectif : Vérifier la création d'un nouvel employé
 
Flux :

Connexion

Navigation vers PIM

Clique sur "Add"

Remplissage du formulaire

Soumission

Vérification dans la liste

Assertions :

L'employé est visible dans la liste

Le nom complet est correct
 

🏆 Bonnes Pratiques
✅ Waits explicites pour tous les éléments interactifs
✅ Messages d'assertion descriptifs
✅ Gestion des ressources avec @AfterMethod
✅ Séparation des préoccupations via méthodes helper
✅ Locators robustes basés sur le texte visible
