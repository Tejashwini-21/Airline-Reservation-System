package miniproject;

class User {
			private String name;
		    private String email;
		    private String password;

		    public User(String name, String email, String password) {
		        this.name = name;
		        this.email = email;
		        this.password = password;
		    }

		    public String getEmail() {
		        return email;
		    }

		    public boolean checkPassword(String password) {
		        return this.password.equals(password);
		    }

		    public String getName() {
		        return name;
		    }
		    
	}   


