import unittest

from source import Account, Site


class TestAccount(unittest.TestCase):

    def setUp(self):
        self.account1 = Account("Ali_Babaei", "5Dj:xKBA", "0030376459", "09121212121", "SAliB_SAliB@gmail.com")

    def test_init(self):
        self.assertEqual(self.account1.username, "Ali_Babaei")
        self.assertIn('_', self.account1.username)
        self.assertEqual(self.account1.username.count('_'), 1)
        self.assertEqual(self.account1.password, 'aca87bf6767f2dbb19d1d5b5d01e3d07eab8ea0f16741bd70e7c0784f0b3916d')
        self.assertEqual(self.account1.user_id, '0030376459')
        self.assertEqual(self.account1.phone, '09121212121')
        self.assertEqual(self.account1.email, 'SAliB_SAliB@gmail.com')


class TestSite(unittest.TestCase):
    def setUp(self):
        self.site1 = Site("salib.net")

    def test_init_site(self):
        self.assertEqual(self.site1.url, "salib.net")
        self.assertListEqual(self.site1.register_users, [])
        self.assertListEqual(self.site1.active_users, [])


if __name__ == '__main__':
    unittest.main()
