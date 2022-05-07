import os


names = {}
lose = "Lose! you can't win this game!"
win = "Win! Normally!"


def add_name(name):
    if names.get(name) is None:
        names[name] = 0
    names[name] = names[name] + 1


def is_file(name : str) -> bool:
    return name.__contains__('.')


def file_name(name):
    return os.path.splitext(name)[0]


def file_extension(name):
    return os.path.splitext(name)[1][1:]


def combet(typ1, typ2, path):
    types = {typ1, typ2}
    counter = {typ1:0, typ2: 0}
    backlog = [path]
    while backlog:
        current : str = backlog.pop()
        entries = os.listdir(current)
        for entry in entries:
            if is_file(entry):
                ext = file_extension(entry)
                if types.__contains__(ext):
                    counter[ext] = counter[ext] + 1
                add_name(file_name(entry))
            else:
                backlog.append(os.path.join(current, entry))
            pass
        pass
    pass
    max_cheat = 0
    cheat_word = ''
    for e in names:
        if names[e] > max_cheat:
            max_cheat = names[e]
            cheat_word = e
    if counter[typ2] > counter[typ1]:
        return win
    elif counter[typ2] + max_cheat > counter[typ1]:
        return f'Win! you can win if you cheat on \'{cheat_word}\'!'
    else:
        return lose
