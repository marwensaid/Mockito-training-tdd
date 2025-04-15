# Mockito Training


### Pourquoi utiliser Mockito ?

1. **Isolation** : Mockito permet d'isoler la classe testée de ses dépendances en créant des objets mock.
2. **Vérification** : Vous pouvez vérifier les interactions entre la classe testée et ses dépendances.
3. **Développement piloté par le comportement (BDD)** : Mockito prend en charge la syntaxe BDD pour rendre vos tests plus lisibles et expressifs.
4. **Flexibilité** : Mockito offre diverses manières de configurer le comportement des objets mock, ce qui le rend flexible et facile à utiliser.

### Prise en main de Mockito

#### 1. Ajouter Mockito à votre projet

Pour utiliser Mockito, vous devez ajouter la dépendance suivante à votre fichier `pom.xml` :

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.6.28</version>
    <scope>test</scope>
</dependency>
```

#### 2. Créer des objets mock

Vous pouvez créer des objets mock à l'aide de l'annotation `@Mock` ou de la méthode `Mockito.mock()`.

```java
@Mock
private BookRepository bookRepository;

@BeforeEach
void setUp() {
    MockitoAnnotations.openMocks(this);
}
```

Ou

```java
BookRepository bookRepository = Mockito.mock(BookRepository.class);
```

#### 3. Configurer le comportement des mocks

Vous pouvez configurer le comportement des objets mock en utilisant la méthode `when()`.

```java
Book book = new Book("123", "Mockito In Action", "John Doe");
when(bookRepository.findBookByIsbn("123")).thenReturn(Optional.of(book));
```

#### 4. Vérifier les interactions

Vous pouvez vérifier les interactions entre la classe testée et ses dépendances en utilisant la méthode `verify()`.

```java
verify(bookRepository, times(1)).addBook(book);
```




### TD1 : Gestion de bibliothèque

#### Énoncé
Vous devez créer une application de gestion de bibliothèque permettant d'ajouter, de rechercher et de supprimer des livres. Vous allez également implémenter des tests unitaires pour cette application en utilisant Mockito.

#### Fonctionnalités à implémenter
1. **Ajouter un livre** : Permettre d'ajouter un livre avec un ISBN, un titre et un auteur.
2. **Rechercher un livre par ISBN** : Permettre de rechercher un livre en utilisant son ISBN.
3. **Supprimer un livre par ISBN** : Permettre de supprimer un livre en utilisant son ISBN.
4. **Lister tous les livres** : Permettre de lister tous les livres dans la bibliothèque.

#### Tests à implémenter
1. **Tests unitaires** : Utiliser Mockito pour tester les services de gestion des livres.

#### Indications sur les mocks
- Utiliser `@Mock` pour créer des objets mock.
- Utiliser `@InjectMocks` pour injecter les mocks dans la classe de service.
- Configurer le comportement des mocks avec `when` et `thenReturn`.
- Vérifier les interactions avec les mocks en utilisant `verify`.

#### Définition et cours sur Mockito
Mockito est un framework de moquage pour Java qui permet de créer des objets factices pour les tests. Il est utilisé pour isoler la classe testée de ses dépendances.

## Introduction à Mockito

Mockito est un framework de moquage populaire pour Java qui permet de créer et de configurer des objets mock pour les tests. Il est couramment utilisé dans les tests unitaires pour isoler la classe testée de ses dépendances. Cela permet de s'assurer que vos tests se concentrent sur le comportement de la classe elle-même plutôt que sur celui de ses dépendances.

### Pourquoi utiliser Mockito ?

1. **Isolation** : Mockito permet d'isoler la classe testée de ses dépendances en créant des objets mock.
2. **Vérification** : Vous pouvez vérifier les interactions entre la classe testée et ses dépendances.
3. **Développement piloté par le comportement (BDD)** : Mockito prend en charge la syntaxe BDD pour rendre vos tests plus lisibles et expressifs.
4. **Flexibilité** : Mockito offre diverses manières de configurer le comportement des objets mock, ce qui le rend flexible et facile à utiliser.

### Prise en main de Mockito

#### 1. Ajouter Mockito à votre projet

Pour utiliser Mockito, vous devez ajouter la dépendance suivante à votre fichier `pom.xml` :

```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>3.6.28</version>
    <scope>test</scope>
</dependency>
```

#### 2. Créer des objets mock

Vous pouvez créer des objets mock à l'aide de l'annotation `@Mock` ou de la méthode `Mockito.mock()`.

```java
@Mock
private BookRepository bookRepository;

@BeforeEach
void setUp() {
    MockitoAnnotations.openMocks(this);
}
```

Ou

```java
BookRepository bookRepository = Mockito.mock(BookRepository.class);
```

#### 3. Configurer le comportement des mocks

Vous pouvez configurer le comportement des objets mock en utilisant la méthode `when()`.

```java
Book book = new Book("123", "Mockito In Action", "John Doe");
when(bookRepository.findBookByIsbn("123")).thenReturn(Optional.of(book));
```

#### 4. Vérifier les interactions

Vous pouvez vérifier les interactions entre la classe testée et ses dépendances en utilisant la méthode `verify()`.

```java
verify(bookRepository, times(1)).addBook(book);
```

### Exemple de test unitaire avec Mockito

```java
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        Book book = new Book("123", "Mockito In Action", "John Doe");
        bookService.addBook(book);
        verify(bookRepository, times(1)).addBook(book);
    }

    @Test
    void testFindBookByIsbn() {
        Book book = new Book("123", "Mockito In Action", "John Doe");
        when(bookRepository.findBookByIsbn("123")).thenReturn(Optional.of(book));

        Book foundBook = bookService.findBookByIsbn("123");
        assertEquals("Mockito In Action", foundBook.getTitle());
    }

    @Test
    void testRemoveBookByIsbn() {
        bookService.removeBookByIsbn("123");
        verify(bookRepository, times(1)).removeBookByIsbn("123");
    }

    @Test
    void testGetAllBooks() {
        bookService.getAllBooks();
        verify(bookRepository, times(1)).getAllBooks();
    }
}
```

### TD2 : Système de gestion de commande

#### Énoncé
Vous devez créer un système de gestion de commande pour un magasin en ligne. Vous allez également implémenter des tests unitaires avancés en utilisant Mockito.

#### Fonctionnalités à implémenter
1. **Créer une commande** : Permettre de créer une commande avec un client et une liste de produits.
2. **Rechercher une commande par ID** : Permettre de rechercher une commande en utilisant son ID.
3. **Annuler une commande** : Permettre d'annuler une commande en utilisant son ID.
4. **Lister toutes les commandes** : Permettre de lister toutes les commandes.

#### Tests à implémenter
1. **Tests unitaires** : Utiliser Mockito pour tester les services de gestion des commandes.
2. **Tests d'intégration** : Vérifier que les différentes couches de l'application fonctionnent correctement ensemble.
3. **Tests de non-régression** : S'assurer que les modifications apportées au code ne cassent pas les fonctionnalités existantes.

#### Indications sur les mocks
- Utiliser `@Mock` pour créer des objets mock.
- Utiliser `@InjectMocks` pour injecter les mocks dans la classe de service.
- Configurer le comportement des mocks avec `when` et `thenReturn`.
- Vérifier les interactions avec les mocks en utilisant `verify`.

### TD3 : Système de gestion d'inventaire

#### Énoncé
Vous devez créer un système de gestion d'inventaire pour un entrepôt. Vous allez également implémenter des tests unitaires avancés, des tests d'intégration et des tests de non-régression en utilisant Mockito.

#### Fonctionnalités à implémenter
1. **Ajouter un article** : Permettre d'ajouter un article avec un nom et une description.
2. **Supprimer un article** : Permettre de supprimer un article en utilisant son ID.
3. **Mettre à jour le stock** : Permettre de mettre à jour la quantité en stock d'un article.
4. **Traiter une transaction** : Permettre d'ajouter ou de retirer des quantités du stock en fonction de la transaction.
5. **Rechercher le stock par ID d'article** : Permettre de rechercher le stock en utilisant l'ID d'un article.

#### Tests à implémenter
1. **Tests unitaires** : Utiliser Mockito pour tester les services de gestion des stocks.
2. **Tests d'intégration** : Vérifier que les différentes couches de l'application fonctionnent correctement ensemble.
3. **Tests de non-régression** : S'assurer que les modifications apportées au code ne cassent pas les fonctionnalités existantes.

#### Indications sur les mocks
- Utiliser `@Mock` pour créer des objets mock.
- Utiliser `@InjectMocks` pour injecter les mocks dans la classe de service.
- Configurer le comportement des mocks avec `when` et `thenReturn`.
- Vérifier les interactions avec les mocks en utilisant `verify`.

### TD4 : Système de gestion des utilisateurs

#### Énoncé
Vous devez créer un système de gestion des utilisateurs pour une application web. Vous allez également implémenter des tests unitaires, des tests d'intégration et des tests de non-régression en utilisant Mockito.

#### Fonctionnalités à implémenter
1. **Ajouter un utilisateur** : Permettre d'ajouter un utilisateur avec un nom et un email.
2. **Rechercher un utilisateur par ID** : Permettre de rechercher un utilisateur en utilisant son ID.
3. **Supprimer un utilisateur** : Permettre de supprimer un utilisateur en utilisant son ID.
4. **Mettre à jour un utilisateur** : Permettre de mettre à jour les informations d'un utilisateur.

#### Tests à implémenter
1. **Tests unitaires** : Utiliser Mockito pour tester les services de gestion des utilisateurs.
2. **Tests d'intégration** : Vérifier que les différentes couches de l'application fonctionnent correctement ensemble.
3. **Tests de non-régression** : S'assurer que les modifications apportées au code ne cassent pas les fonctionnalités existantes.

#### Indications sur les mocks
- Utiliser `@Mock` pour créer des objets mock.
- Utiliser `@InjectMocks` pour injecter les mocks dans la classe de service.
- Configurer le comportement des mocks avec `when` et `thenReturn`.
- Vérifier les interactions avec les mocks en utilisant `verify`.

### Exemple de test unitaire avec Mockito

```java
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(1L, "John Doe", "john.doe@example.com");
    }

    @Test
    void testAddUser() {
        userService.addUser(user);
        verify(userRepository, times(1)).addUser(user);
    }

    @Test
    void testFindUserById() {
        when(userRepository.findUserById(1L)).thenReturn(Optional.of(user));

        User foundUser = userService.findUserById(1L);
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testRemoveUser() {
        userService.removeUser(1L);
        verify(userRepository, times(1)).removeUserById(1L);
    }

    @Test
    void testUpdateUser() {
        userService.updateUser(user);
        verify(userRepository, times(1)).updateUser(user);
    }
}
```

### Exemple de test d'intégration

```java
class UserIntegrationTest {

    private UserRepository userRepository;
    private UserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userService = new UserServiceImpl(userRepository);
        user = new User(1L, "John Doe", "john.doe@example.com");
    }

    @Test
    void testAddAndFindUser() {
        userService.addUser(user);
        User foundUser = userService.findUserById(1L);

        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testRemoveUser() {
        userService.addUser(user);
        userService.removeUser(1L);

        User foundUser = userService.findUserById(1L);
        assertNotNull(foundUser);
    }

    @Test
    void testUpdateUser() {
        userService.addUser(user);
        user.setName("Jane Doe");
        userService.updateUser(user);

        User updatedUser = userService.findUserById(1L);
        assertEquals("Jane Doe", updatedUser.getName());
    }
}
```

### Exemple de test de non-régression

```java
class UserRegressionTest {

    private UserRepository userRepository;
    private UserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userService = new UserServiceImpl(userRepository);
        user = new User(1L, "John Doe", "john.doe@example.com");
    }

    @Test
    void testAddUserRegression() {
        userService.addUser(user);
        User foundUser = userService.findUserById(1L);

        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testRemoveUserRegression() {
        userService.addUser(user);
        userService.removeUser(1L);

        User foundUser = userService.findUserById(1L);
        assertNull(foundUser);
    }

    @Test
    void testUpdateUserRegression() {
        userService.addUser(user);
        user.setName("Jane Doe");
        userService.updateUser(user);

        User updatedUser = userService.findUserById(1L);
        assertEquals("Jane Doe", updatedUser.getName());
    }
}
```
