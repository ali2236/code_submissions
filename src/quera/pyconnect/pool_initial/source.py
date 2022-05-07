class Site:
    def __init__(self, url_address):

        pass

    def show_users(self):
        pass

    def register(self, user):
        pass

    def login(self, **kwargs):
        pass

    def logout(self, user):
        pass

    def __repr__(self):
        return "Site url:%s\nregister_users:%s\nactive_users:%s" % (self.url, self.register_users, self.active_users)

    def __str__(self):
        return self.url


class Account:
    def __init__(self, username, password, user_id, phone, email):
        pass

    def set_new_password(self, password):
        pass

    def username_validation(self, username):
        pass

    def password_validation(self, password):
        pass

    def id_validation(self, id):
        pass

    def phone_validation(self, phone):
        pass

    def email_validation(self, email):
        pass

    def __repr__(self):
        return self.username

    def __str__(self):
        return self.username


def show_welcome(func):
    pass

def verify_change_password(func):
    pass

@show_welcome
def welcome(user):
    return ("welcome to our site %s" % user)

@verify_change_password
def change_password(user, old_pass, new_pass):
    return ("your password is changed successfully.")

