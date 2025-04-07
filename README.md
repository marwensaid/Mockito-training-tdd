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
