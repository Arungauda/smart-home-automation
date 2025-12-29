package repository;

import rule.AutomationRule;

import java.util.List;

public interface AutomationRuleRepository {
     void save(AutomationRule rule);
     List<AutomationRule> findAll();
}
