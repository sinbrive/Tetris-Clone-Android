package com.example.tetris;


public class Tetros {

    final Point [][] t_L = {
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, 2),
                    new Point(1, 2)
            },

            {
                    new Point(2, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(2, 1)
            },

            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(1, 1),
                    new Point(1, 2)
            },

            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(2, 0)
            }
    };


    final Point [][] t_O = {
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(1, 1)
            }
    };

    final Point [][] t_I = {
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(2, 0),
                    new Point(3, 0)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, 2),
                    new Point(0, 3),

            },
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(2, 0),
                    new Point(3, 0)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, 2),
                    new Point(0, 3)

            }
    };

    final Point [][] t_T = {
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(2, 0),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(0, 2)
            },
            {
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(2, 1)
            },
            {
                    new Point(0, 1),
                    new Point(1, 0),
                    new Point(1, 1),
                    new Point(1, 2)
            }
    };


    final Point [][] t_J = {
            {
                    new Point(1, 0),
                    new Point(1, 1),
                    new Point(0, 2),
                    new Point(1, 2)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(2, 1)
            },
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(0, 2)
            },
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(1, 1),
                    new Point(1, 2)
            }
    };

    final Point [][] t_S = {
            {
                    new Point(1, 0),
                    new Point(2, 0),
                    new Point(0, 1),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(1, 2)
            },
            {
                    new Point(1, 0),
                    new Point(2, 0),
                    new Point(0, 1),
                    new Point(1, 1)
            },
            {
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(1, 2)
            }
    };


    final Point [][] t_Z = {
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(1, 1),
                    new Point(2, 1)
            },
            {
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(0, 2)
            },
            {
                    new Point(0, 0),
                    new Point(1, 0),
                    new Point(1, 1),
                    new Point(2, 1)
            },
            {
                    new Point(1, 0),
                    new Point(0, 1),
                    new Point(1, 1),
                    new Point(0, 2)
            }
    };

    public  final Point [][][] tetrosList = {t_I, t_J, t_L, t_O, t_T, t_S, t_Z};
}
