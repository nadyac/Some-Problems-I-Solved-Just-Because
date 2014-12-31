#Solution Unit Tester

import unittest
import Solution

class solutionTest(unittest.TestCase):

	# set up
	def setUp(self):
		#This is a setup function that gets run before each test, we won't use it.
		pass

	def test_answers_1(self):
		self.assertEqual(Solution.answer(2,3,14), "Ambiguous")
		self.assertEqual(Solution.answer(19,19,3), "03/19/19")

if __name__ == '__main__':
	unittest.main()

