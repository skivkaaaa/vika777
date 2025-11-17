Python реализации
Бинарная куча - система приоритетной обработки задач

python
import heapq

class TaskManager:
    def __init__(self):
        self.tasks = []
    
    def add_task(self, priority, description):
        heapq.heappush(self.tasks, (priority, description))
        print(f"Добавлена задача: {description} (приоритет: {priority})")
    
    def process_tasks(self):
        print("\nОбработка задач по приоритету:")
        while self.tasks:
            priority, task = heapq.heappop(self.tasks)
            print(f"Выполняется: {task} (приоритет: {priority})")

# Использование
manager = TaskManager()
manager.add_task(2, "Проверить почту")
manager.add_task(1, "Срочный звонок")
manager.add_task(3, "Составить отчет")
manager.process_tasks()
Хеш-таблица - система управления пользователями

python
class UserDatabase:
    def __init__(self, size=10):
        self.size = size
        self.table = [[] for _ in range(size)]
    
    def _hash(self, key):
        return hash(key) % self.size
    
    def add_user(self, username, user_data):
        index = self._hash(username)
        for i, (user, _) in enumerate(self.table[index]):
            if user == username:
                self.table[index][i] = (username, user_data)
                return
        self.table[index].append((username, user_data))
    
    def get_user(self, username):
        index = self._hash(username)
        for user, data in self.table[index]:
            if user == username:
                return data
        return None
    
    def display_users(self):
        for i, bucket in enumerate(self.table):
            if bucket:
                print(f"Бакет {i}: {bucket}")

# Использование
db = UserDatabase()
db.add_user("alice", {"name": "Алиса", "age": 25})
db.add_user("bob", {"name": "Боб", "age": 30})
print("Данные Алисы:", db.get_user("alice"))
db.display_users()
