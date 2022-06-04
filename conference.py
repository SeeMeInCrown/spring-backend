import csv

data = [[1, 1, 'Berke Ayan,Meliha Buse', 'Berke Ayan', 'Intro to Robotics', 'robotics, science',
         '10:30', '11:30', 2, ],
        [1, 1, 'Berke Ayan,Meliha Buse', 'Berke Ayan', 'Intro to Robotics', 'robotics, science',
         '10:30', '11:30', 2, ],
        [1, 1, 'Berke Ayan,Meliha Buse', 'Berke Ayan', 'Intro to Robotics', 'robotics, science',
         '10:30', '11:30', 2, ]]

with open('result.csv', 'w') as f:
    writer = csv.writer(f)
    writer.writerows(data)
