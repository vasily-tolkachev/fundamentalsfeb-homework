package subtasks.five;

public enum Discipline {
    BIOLOGY {
        @Override
        public boolean areGradesInteger() {
            return false;
        }
    }, PHYSICS {
        @Override
        public boolean areGradesInteger() {
            return true;
        }
    }, MATHEMATICS {
        @Override
        public boolean areGradesInteger() {
            return true;
        }
    }, ENGLISH {
        @Override
        public boolean areGradesInteger() {
            return false;
        }
    }, CHEMISTRY {
        @Override
        public boolean areGradesInteger() {
            return true;
        }
    }, HISTORY {
        @Override
        public boolean areGradesInteger() {
            return false;
        }
    }, PHILOSOPHY {
        @Override
        public boolean areGradesInteger() {
            return false;
        }
    };

    public abstract boolean areGradesInteger();
}
