import csv

fields = ['esm', 'famil', 'keshvar', 'rang', 'ashia', 'ghaza']
data = {
    'esm': set(),
    'famil': set(),
    'keshvar': set(),
    'rang': set(),
    'ashia': set(),
    'ghaza': set(),
}


def ready_up():
    with open('esm_famil_data.csv', encoding="utf8") as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        line_count = 0
        r = range(len(fields))
        for row in csv_reader:
            if line_count == 0:
                line_count += 1
            else:
                for i in r:
                    data[fields[i]].add(row[i].replace(" ", ""))
                line_count += 1
    pass


participants = {}
scores = {}


def add_participant(participant, answers):
    participants[participant] = answers
    scores[participant] = 0
    pass


def everybody_answered(field) -> bool:
    for participant in participants:
        if len(get_answer(participant, field)) < 1:
            return False
    return True


def check_answer(field, answer):
    if len(answer) < 1:
        return False
    elif data[field].__contains__(answer):
        return True
    return False


def get_answer(participant, field) -> str:
    return participants[participant][field].replace(" ", "")


def calculate_all():
    for field in fields:
        score_type = everybody_answered(field)
        _half_score = 5 if score_type else 10
        _full_score = 10 if score_type else 15
        answers = {}
        for participant in participants:
            answer = get_answer(participant, field)
            valid = check_answer(field, answer)
            if valid:
                if answers.get(answer) is None:
                    answers[answer] = set()
                answers[answer].add(participant)
        for vp in answers:
            scr = _full_score if len(answers[vp]) == 1 else _half_score
            for p in answers[vp]:
                ns = scores[p] + scr
                scores[p] = ns
    return scores