# TP1 : Injection des dépendances en Java

## Partie 1 : Interfaces et implémentations

### 1. Interface `IDao`
- Méthode principale : `getData()`
- Sert à récupérer des données (ici un simple double pour l'exemple).

### 2. Implémentation de `IDao`
- Classe `DaoImpl` qui implémente `IDao`.
- Retourne une valeur fixe pour la démonstration (ex : 100).

### 3. Interface `IMetier`
- Méthode principale : `calcul()`
- Sert à réaliser un traitement ou calcul en utilisant les données fournies par `IDao`.

### 4. Implémentation de `IMetier` (couplage faible)
- Classe `MetierImpl` qui implémente `IMetier`.
- Utilise une référence à `IDao` au lieu d'une instance concrète (`DaoImpl`), ce qui permet un **couplage faible**.

---

## Partie 2 : Injection des dépendances

### a. Instanciation statique
- L’objet `DaoImpl` est créé directement dans le code de `MetierImpl`.
- Exemple : `IDao dao = new DaoImpl();`
- **Inconvénient** : couplage fort, difficile à modifier ou tester.

### b. Instanciation dynamique
- Utilisation de **réflexion Java** et d’un fichier `config.txt` contenant les noms des classes.
- Le programme lit le nom des classes et crée les instances dynamiquement.
- Permet de changer l’implémentation sans modifier le code source.
- Illustré par le principe suivant : on lit les noms de classes, puis `Class.forName` et `newInstance()` créent les objets à la volée.

### c. Framework Spring

#### Version XML
- Les beans (`DaoImpl` et `MetierImpl`) sont définis dans un fichier de configuration XML (`applicationContext.xml`).
- Spring lit ce fichier au démarrage, crée les instances des classes, et injecte automatiquement la dépendance `DaoImpl` dans `MetierImpl`.
- Cette approche permet de **dissocier totalement le code métier de la configuration des objets**, facilitant la maintenance et la réutilisation.

#### Version Annotations
- Les classes sont annotées avec `@Component` pour indiquer à Spring qu’elles doivent être gérées comme beans.
- L’injection se fait automatiquement grâce à l’annotation `@Autowired`.
- La configuration se fait dans une classe Java avec `@Configuration` et `@ComponentScan`, ce qui évite les fichiers XML et simplifie la gestion des dépendances.
- Cette approche est plus moderne et réduit le code nécessaire tout en conservant le **couplage faible** entre les composants.

---

### Résultat attendu
- Dans toutes les versions (statique, dynamique, XML, annotations), l’application exécute le calcul en utilisant le DAO injecté et affiche le résultat attendu.
- L’utilisation de Spring illustre le **principe d’injection de dépendances**, avec création et gestion automatique des objets par le framework.

---

### Conclusion
- **Instanciation statique** : simple mais couplage fort.
- **Instanciation dynamique** : flexible grâce à la réflexion, couplage faible.
- **Spring (XML ou annotations)** : configuration automatique, couplage faible, maintenance facilitée.
- Ce TP permet de comprendre les différents mécanismes pour gérer les dépendances et leur injection en Java.
