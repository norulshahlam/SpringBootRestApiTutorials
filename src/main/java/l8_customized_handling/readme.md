

last lesson we learnt how to DEFINE a status message with standard 
structure defined by spring mvc.

### 1. this lesson will learn how to CUSTOMIZE response structure (to fit our requirement)
create 1 generic exception handler for different status code
create diff exception handler for different status code 
create exception handler when validation fails
usually the standard structure will be timestamp, message, detail.

### 2. we will also learn how to delete user and give status code if fail or success
if fail - we return the same exception handling used in retrieveUser()



### 3. how to do validation - eg make sure name is atleast 2 char 
add validation dependencies
add @Valid in UserResource.createUser. then,
add @Size & @Past in user pojo to define your validation - name > 2char, date !today onwards
use customised excepton handler to set your own status message 
and default message, like the ones used in retrieveUSer()

we can also add our own details when validation failed in pojo eg:
@Size(min = 2, message = "name must have atleast 2 char")

getBindingResult() - contains details of what went wrong 
when validation fails

### 4. add user with id and validate
--return simple message - user exists

u can add into exception handler so we can have standard response message
