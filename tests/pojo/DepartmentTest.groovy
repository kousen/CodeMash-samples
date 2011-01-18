package pojo
;

import static org.junit.Assert.*;

import org.junit.Test;

import spock.lang.Specification;

class DepartmentTest extends Specification {
    private Department dept;
    
    def setup() {
        dept = new Department(name:'IT')
    }
    
    def "add employee to dept should increase total by 1"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        
        when:
        dept = dept + fred
        
        then:
        dept.employees.size() == old(dept.employees.size()) + 1
    }
    
    def "add two employees via chained plus"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        Employee barney = new Employee(name:'Barney',id:2)
        
        when:
        dept = dept + fred + barney
        
        then:
        dept.employees.size() == 2
    }
    
    def "subtract emp from dept should decrease by 1"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        dept.hire fred
        
        when:
        dept = dept - fred
        
        then:
        dept.employees.size() == old(dept.employees.size()) - 1
    }

    def "remove two employees via chained minus"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        Employee barney = new Employee(name:'Barney',id:2)
        dept.hire fred
        dept.hire barney
        
        when:
        dept = dept - fred - barney
        
        then:
        dept.employees.size() == 0
    }

    def "add employee to dept via left shift should increase total by 1"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        
        when:
        dept = dept << fred
        
        then:
        dept.employees.size() == old(dept.employees.size()) + 1
    }
    
    def "add two employees via chained left shift"() {
        given:
        Employee fred = new Employee(name:'Fred',id:1)
        Employee barney = new Employee(name:'Barney',id:2)
        
        when:
        dept = dept << fred << barney
        
        then:
        dept.employees.size() == 2
    }
    
}
