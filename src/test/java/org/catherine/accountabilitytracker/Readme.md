https://jsonplaceholder.typicode.com/

@RequestParam = used to extract query parameters from the URL. eg: /posts?userId=1
@PathVariable = used to extract path variables from the URL. eg: /posts/1

@SpringBootTest = loads all beans in the application context. Use @MockBean for stubbing
@WebMvcTest = loads only the web layer beans (controllers, filters, etc.) and not the full application context. It is useful for testing controllers in isolation.
ed for web layer tests - loads only the web layer beans (controllers, filters, etc.) Any other beans (like services, repositories) need to be mocked using @MockBean.

@Mock - for unit tests.
@MockBean - replaces this bean in the application context.

But you need to mock only 1 or 2 beans, you can use @MockBean to mock those specific beans.


✅@InjectMocks = creates a real instance of the class and injects @Mock dependencies into it (via constructor/setter/field).

✅ @Mock = just creates a mock object with no logic, often used for dependencies.