package handler;

import mappingclass.Contract;

import java.util.ArrayList;
import java.util.List;

public final class Distributor implements Billing {
    private int id;
    private int contractLength;
    private int budget;
    private int infrastructureCost;
    private int productionCost;
    private boolean isBankrupt;
    private List<Contract> contracts;
    private int contractCost;
    private static List<Distributor> newDistributors;

    public Distributor() {
        this.isBankrupt = false;
    }

    public Distributor(final mappingclass.Distributor distributor) {
        this.contractLength = distributor.getContractLength();
        this.id = distributor.getId();
        this.budget = distributor.getInitialBudget();
        this.infrastructureCost = distributor.getInitialInfrastructureCost();
        this.productionCost = distributor.getInitialProductionCost();
        this.contracts = new ArrayList<>();
        this.isBankrupt = false;
        this.contractCost = 0;
    }

    /**
     * Paying distributors' expenses and then deleting
     * bankrupt consumers (we provided them energy already)
     * @param consumers current state of consumers
     * @param distributors current state of distributors
     */
    @Override
    public void getStatus(final List<Consumer> consumers,
                          final List<Distributor> distributors) {
        newDistributors = distributors;

        for (int i = 0; i < newDistributors.size(); ++i) {
            if (!distributors.get(i).isBankrupt) {
                int infrastructure = newDistributors.get(i).getInfrastructureCost();
                int production = newDistributors.get(i).getProductionCost();
                int totalCost;
                int currentBudget = newDistributors.get(i).getBudget();
                if (newDistributors.get(i).getContracts().size() == 0) {
                    totalCost = infrastructure;
                } else {
                    totalCost = infrastructure
                            + production * newDistributors.get(i).getContracts().size();
                }
                if (currentBudget >= totalCost) {
                    currentBudget -= totalCost;
                    newDistributors.get(i).setBudget(currentBudget);
                } else {
                    currentBudget -= totalCost;
                    newDistributors.get(i).setBankrupt(true);
                    newDistributors.get(i).setBudget(currentBudget);
                }
            }
        }

        for (Distributor newDistributor : newDistributors) {
            List<Contract> newContracts = newDistributor.getContracts();
            for (Consumer consumer : consumers) {
                if (consumer.isBankrupt()) {
                    for (int k = 0; k < newContracts.size(); ++k) {
                        if (newContracts.get(k).getConsumerId() == consumer.getId()) {
                            newContracts.remove(newContracts.get(k));
                            newDistributor.setContracts(newContracts);
                        }
                    }
                }
            }
        }
    }

    /**
     * Computing contracts' cost
     * @param consumers current state of consumers
     * @param distributors current state of distributors
     */
    @Override
    public void establishContract(final List<Consumer> consumers,
                                  final List<Distributor> distributors) {
        newDistributors = distributors;
        for (Distributor newDistributor : newDistributors) {
            final double factor = 0.2;
            if (newDistributor.getContracts().size() == 0) {
                newDistributor.setContractCost(newDistributor.getInfrastructureCost()
                        + newDistributor.getProductionCost()
                        + (int)
                        Math.round(Math.floor(factor * newDistributor.getProductionCost())));
            } else {
                double temp = Math.floor((double) newDistributor.getInfrastructureCost()
                        / newDistributor.getContracts().size());
                newDistributor.setContractCost((int) Math.round(temp
                        + newDistributor.getProductionCost()
                        + (int)
                        Math.round(Math.floor(factor * newDistributor.getProductionCost()))));
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(final int budget) {
        this.budget = budget;
    }

    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(final int productionCost) {
        this.productionCost = productionCost;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(final List<Contract> contracts) {
        this.contracts = contracts;
    }

    public static List<Distributor> getNewDistributors() {
        return newDistributors;
    }

    public static void setNewDistributors(final List<Distributor> distributors) {
        newDistributors = distributors;
    }

    public int getContractCost() {
        return contractCost;
    }

    public void setContractCost(final int contractCost) {
        this.contractCost = contractCost;
    }
}
