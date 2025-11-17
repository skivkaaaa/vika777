Python реализации
Мультисписок - система управления отделами компании

python
class DepartmentManager:
    def __init__(self):
        self.departments = [
            ['Иван Петров', 'Мария Сидорова'],
            ['Алексей Козлов', 'Ольга Новикова', 'Сергей Иванов'],
            ['Дмитрий Смирнов']
        ]
    
    def flatten_employees(self):
        """Преобразование вложенного списка в плоский"""
        all_employees = []
        for department in self.departments:
            all_employees.extend(department)
        return all_employees
    
    def add_employee(self, department_index, employee):
        """Добавление сотрудника в отдел"""
        if department_index < len(self.departments):
            self.departments[department_index].append(employee)
    
    def display_structure(self):
        """Отображение структуры компании"""
        for i, department in enumerate(self.departments, 1):
            print(f"Отдел {i}: {department}")

# Использование
manager = DepartmentManager()
print("Исходная структура:")
manager.display_structure()

print("\nВсе сотрудники:", manager.flatten_employees())

manager.add_employee(0, "Елена Васильева")
print("\nПосле добавления сотрудника:")
manager.display_structure()
Очередь и дек - система обработки заявок

python
from collections import deque
import queue

class RequestSystem:
    def __init__(self):
        self.standard_queue = queue.Queue()
        self.urgent_deque = deque()
    
    def add_standard_request(self, request):
        """Добавление стандартной заявки"""
        self.standard_queue.put(request)
        print(f"Добавлена стандартная заявка: {request}")
    
    def add_urgent_request(self, request):
        """Добавление срочной заявки в начало"""
        self.urgent_deque.appendleft(request)
        print(f"Добавлена срочная заявка: {request}")
    
    def process_requests(self):
        """Обработка заявок (сначала срочные, потом стандартные)"""
        print("\nОбработка заявок:")
        
        # Обрабатываем срочные заявки
        while self.urgent_deque:
            request = self.urgent_deque.popleft()
            print(f"Обработана срочная заявка: {request}")
        
        # Обрабатываем стандартные заявки
        while not self.standard_queue.empty():
            request = self.standard_queue.get()
            print(f"Обработана стандартная заявка: {request}")

# Использование
system = RequestSystem()
system.add_standard_request("Ремонт компьютера")
system.add_urgent_request("Сервер упал!")
system.add_standard_request("Установка ПО")
system.add_urgent_request("Критическая ошибка")

system.process_requests()
Приоритетная очередь - система обслуживания клиентов

python
import heapq

class CustomerService:
    def __init__(self):
        self.customers = []
    
    def add_customer(self, name, priority, issue):
        """Добавление клиента с приоритетом"""
        heapq.heappush(self.customers, (priority, name, issue))
        print(f"Добавлен клиент: {name} (приоритет: {priority})")
    
    def serve_customers(self):
        """Обслуживание клиентов по приоритету"""
        print("\nОбслуживание клиентов:")
        while self.customers:
            priority, name, issue = heapq.heappop(self.customers)
            print(f"Обслуживается: {name} | Проблема: {issue} | Приоритет: {priority}")

# Использование
service = CustomerService()
service.add_customer("Анна", 2, "Вопрос по оплате")
service.add_customer("Петр", 1, "Техническая поддержка")  # Высший приоритет
service.add_customer("Мария", 3, "Консультация")
service.add_customer("Алексей", 1, "Срочная проблема")

service.serve_customers()
