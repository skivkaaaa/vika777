C++ реализации
Биномиальная куча - система управления ресурсами

cpp
#include <iostream>
#include <vector>
#include <algorithm>

class ResourceManager {
private:
    std::vector<int> heap;
    
    void heapifyUp(int index) {
        while (index > 0 && heap[(index-1)/2] > heap[index]) {
            std::swap(heap[(index-1)/2], heap[index]);
            index = (index-1)/2;
        }
    }
    
    void heapifyDown(int index) {
        int smallest = index;
        int left = 2*index + 1;
        int right = 2*index + 2;
        
        if (left < heap.size() && heap[left] < heap[smallest])
            smallest = left;
        if (right < heap.size() && heap[right] < heap[smallest])
            smallest = right;
            
        if (smallest != index) {
            std::swap(heap[index], heap[smallest]);
            heapifyDown(smallest);
        }
    }
    
public:
    void allocateResource(int priority) {
        heap.push_back(priority);
        heapifyUp(heap.size()-1);
        std::cout << "Выделен ресурс с приоритетом: " << priority << std::endl;
    }
    
    int releaseResource() {
        if (heap.empty()) return -1;
        
        int resource = heap[0];
        heap[0] = heap.back();
        heap.pop_back();
        heapifyDown(0);
        
        std::cout << "Освобожден ресурс с приоритетом: " << resource << std::endl;
        return resource;
    }
    
    void displayResources() {
        std::cout << "Текущие ресурсы: ";
        for (int res : heap) std::cout << res << " ";
        std::cout << std::endl;
    }
};

// Использование
int main() {
    ResourceManager manager;
    manager.allocateResource(3);
    manager.allocateResource(1);
    manager.allocateResource(2);
    manager.displayResources();
    manager.releaseResource();
    manager.displayResources();
    return 0;
}
