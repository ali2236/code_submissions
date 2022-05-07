def game(number):
    a = number // 10
    b = number % 10
    c = max(a, b) - min(a, b)
    return c