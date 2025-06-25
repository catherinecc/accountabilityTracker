| Term                         | 🔑 Summary                                            |
|------------------------------| ----------------------------------------------------- |
| **Authentication**           | Identifies **who you are** (e.g., login)              |
| **Autho-ri-zation** (rights) | Determines **what you can do** (e.g., access control) |

Spring security:
Provides Basic HTTP authentication
    -  The client sends the username and password in the Authorization header.- Basic <base64(username:password)>
# Spring Security with JWT

Required dependencies:
jwt-api
jwt-implementaion
jwt-jackson

Why JWT?
In Basic Authentication,
    - the base64 encoded string of username and password is sent with every request.
    - This is not secure as the credentials are sent with every request.
In JWT,
    - the user is authenticated once and a token is generated.
    - This token is sent with every request in the Authorization header
    - The server verifies the token and grants access to the user.
    - The token contains all the information about the user. you can add custom claims(more data) to the token.
    - The token is signed by the server to ensure its integrity.


JWT:
has 3 parts separated by dots (.)
- Header
    - Type (JWT)
    - Algorithm ( Signing Algorithm )
- Payload
  - Claims - information about the user and other data
    - Registered Claims
    - Public Claims
    - Private Claims
- Signature - used to verify the integrity of the user and the data

  