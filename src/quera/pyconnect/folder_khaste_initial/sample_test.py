import os
import sys
import unittest


class ScoreListTest(unittest.TestCase):
    def _makeOne(self, clear=False):
        if clear:
            try:
                del sys.modules['source']
            except KeyError:
                pass
        import source
        return source

    def test_sample_win_normally(self):
        cur = self._makeOne(clear = True)
        test_path = 'sample_tests/1'
        sajjad_format = 'mp4'
        salib_format = 'jpg'
        user_answer = cur.combet(salib_format, sajjad_format, test_path)
        self.assertEqual(user_answer, "Win! Normally!")

    def test_sample_win_with_cheat(self):
        cur = self._makeOne(clear = True)
        test_path = 'sample_tests/2'
        sajjad_format = 'jpg'
        salib_format = 'mp4'
        user_answer = cur.combet(salib_format, sajjad_format, test_path)
        print(user_answer)
        user_cheat = user_answer.split("'")[1]
        salib = 0
        sajjad = 0
        for obj in os.walk(test_path):
            for file in obj[2]:
                if "." in file:
                    if file.split('.')[-1] == sajjad_format or file.split('.')[0] == user_cheat:
                        sajjad += 1
                    elif file.split('.')[-1] == salib_format:
                        salib += 1
        self.assertGreater(sajjad, salib)
        self.assertEqual(user_answer.split("'")[0], 'Win! you can win if you cheat on ')
        self.assertEqual(user_answer.split("'")[2], '!')


if __name__ == '__main__':
    unittest.main()
